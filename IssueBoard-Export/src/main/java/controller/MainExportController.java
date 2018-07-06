package controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import csvFormatter.model.Entry;
import csvFormatter.model.Format;
import csvFormatter.service.CsvFile;
import csvFormatter.service.CsvWriter;
import interfaces.GitController;
import interfaces.ZenController;
import model.GitDump;
import model.RepoInfo;
import model.ZenhubInfo;
import model.filtering.FilteredList;
import model.filtering.filters.Filter;
import model.issues.exportable.ExportableDump;
import model.issues.exportable.ExportableIssue;
import model.issues.exportable.ExportableIssueComparator;
import model.issues.exportable.ExportableSeverityComparator;
import model.issues.exportable.filters.BugFilter;
import model.issues.exportable.filters.EpicFilter;
import model.issues.exportable.filters.MilestoneFilter;
import model.issues.interfaces.GitMilestone;
import model.issues.interfaces.ZenIssue;
import service.DataSourceService;
import service.EntryService;
import service.ExportableService;
import service.Finals;
import service.FormatService;
import service.IssueWriter;
import service.MainOutputService;
import service.factories.ObjectFactory;

public class MainExportController {

	private IssueWriter issueWriter;

	private FormatService formatService;

	private ExportableService exportableService;

	private EntryService entryService;

	private ObjectFactory objectFactory;

	private MainOutputService mainOutputService;

	private boolean working = false;
	
	public synchronized boolean isWorking()
	{
		return working;
	}
	
	private void writeByMilestone(ExportableDump exportableDump, String folderName, Format format,
			List<Filter<ExportableIssue>> filters) throws IOException {
		IssueWriter writer = getIssueWriter();
		for (GitMilestone milestone : exportableDump.milestoneList) {

			FilteredList<ExportableIssue> issueList = new FilteredList<>(exportableDump.issues);

			issueList.addFilter(new MilestoneFilter(milestone.getTitle()));

			for (Filter<ExportableIssue> filter : filters) {
				issueList.addFilter(filter);
			}

			writer.writeMilestone(folderName, milestone, issueList.getFiltered(), format);
			
		}
	}

	private void writeList(CsvWriter writer, List<ExportableIssue> issues, Format format) throws IOException {
		List<Entry> entries = new ArrayList<>();

		for (ExportableIssue issue : issues) {
			entries.add(entryService.convertToEntry(issue));
		}

		writer.writeEntries(format, entries);

		writer.close();

	}

	private ExportableDump loadData(RepoInfo repoInfo, ZenhubInfo zenhubInfo) throws IOException {

		mainOutputService.write("Loading Data");

		GitController githubController = getObjectFactory().buildGitController();

		githubController.setRepoInfo(repoInfo);

		ZenController zenhubController = getObjectFactory().buildZenController();

		zenhubController.setZenhubInfo(zenhubInfo);

		GitDump gitDump = githubController.getGitData();

		List<ZenIssue> zenIssues = zenhubController.getZenIssues();

		return getExportableService().getExportables(gitDump, zenIssues);

	}

	private String makeDirectories() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String folderName = "issues/" + dateFormat.format(Date.from(Instant.now()));

		File file = new File(folderName);

		file.mkdirs();

		file = new File(folderName + Finals.BY_MILESTONE);

		file.mkdirs();

		return folderName;
	}

	private void writeList(FilteredList<ExportableIssue> issues, String folderName, Format format,
			List<Filter<ExportableIssue>> filters, Comparator<ExportableIssue> comparator, String filename)
			throws IOException {
		issues.clearFilters();

		for (Filter<ExportableIssue> filter : filters) {
			issues.addFilter(filter);
		}

		issues.getFiltered().sort(comparator);

		CsvWriter writer = new CsvWriter(folderName + filename);

		writeList(writer, issues.getFiltered(), format);
	}

	public void defaultControlFlow(List<Filter<ExportableIssue>> filters) throws IOException {

		working = true;
		
		mainOutputService.clear();

		DataSourceService.loadTokens();
		final String repoName = "vet360.pm";

		final String repoOwner = "department-of-veterans-affairs";

		final String boardId = "83798140";

		String folderName = makeDirectories();

		Format format = getFormatService().getFormat();

		RepoInfo repoInfo = new RepoInfo(repoName, repoOwner, DataSourceService.GITHUB_AUTH_TOKEN);

		ZenhubInfo zenInfo = new ZenhubInfo(DataSourceService.ZENHUB_AUTH_TOKEN, boardId);

		ExportableDump exportableDump = loadData(repoInfo, zenInfo);

		CsvFile.setOutputDelimiter(",");

		mainOutputService.write("Writing files");

		FilteredList<ExportableIssue> exportableList = new FilteredList<>(exportableDump.issues);

		writeByMilestone(exportableDump, folderName, format, filters);

		List<Filter<ExportableIssue>> bugFilters = new ArrayList<>(filters);

		bugFilters.add(new BugFilter());

		List<Filter<ExportableIssue>> epicFilters = new ArrayList<>(filters);

		epicFilters.add(new EpicFilter());

		writeList(exportableList, folderName, format, bugFilters, new ExportableSeverityComparator(), "/Bugs.csv");

		writeList(exportableList, folderName, format, epicFilters, new ExportableIssueComparator(), "/Epics.csv");

		mainOutputService.write("Finished writing");

		working = false;
		
	}

	public IssueWriter getIssueWriter() {
		return issueWriter;
	}

	public void setIssueWriter(IssueWriter issueWriter) {
		this.issueWriter = issueWriter;
	}

	public FormatService getFormatService() {
		return formatService;
	}

	public void setFormatService(FormatService formatService) {
		this.formatService = formatService;
	}

	public ExportableService getExportableService() {
		return exportableService;
	}

	public void setExportableService(ExportableService exportableService) {
		this.exportableService = exportableService;
	}

	public EntryService getEntryService() {
		return entryService;
	}

	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}

	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	public MainOutputService getMainOutputService() {
		return mainOutputService;
	}

	public void setMainOutputService(MainOutputService mainOutputService) {
		this.mainOutputService = mainOutputService;
	}
}
