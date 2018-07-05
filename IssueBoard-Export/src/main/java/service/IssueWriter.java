package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csvFormatter.model.Entry;
import csvFormatter.model.Format;
import csvFormatter.service.CsvWriter;
import model.issues.exportable.ExportableIssue;
import model.issues.exportable.ExportableIssueComparator;
import model.issues.interfaces.GitMilestone;

public class IssueWriter {

	private EntryService entryService;

	public void writeMilestone(String folderName, GitMilestone milestone, List<ExportableIssue> issues, Format format)
			throws IOException {

		CsvWriter writer = new CsvWriter(folderName + Finals.BY_MILESTONE + milestone.getTitle() + ".csv");

		if (issues == null || issues.isEmpty()) {
			writer.close();
			return;
		}

		issues.sort(new ExportableIssueComparator());

		List<Entry> entries = new ArrayList<>();

		for (ExportableIssue issue : issues) {
			entries.add(entryService.convertToEntry(issue));
		}

		writer.writeEntries(format, entries);

		writer.close();
	}

	public EntryService getEntryService() {
		return entryService;
	}

	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}

}