package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.GitDump;
import model.issues.exportable.ExportableDump;
import model.issues.exportable.ExportableIssue;
import model.issues.exportable.Issue;
import model.issues.interfaces.GitIssue;
import model.issues.interfaces.ZenIssue;

public class ExportableService {

	public ExportableDump getExportables(GitDump gitDump, List<ZenIssue> zenIssues) {

		ExportableDump exportDump = new ExportableDump();

		Map<Integer, ZenIssue> zenMap = new HashMap<>();

		for (ZenIssue zenIssue : zenIssues) {

			zenMap.put(zenIssue.getIssue_number(), zenIssue);

		}

		exportDump.milestoneList.addAll(gitDump.milestones);
		
		for (GitIssue Issue : gitDump.issues) {

			String key = null;

			if (Issue.getMilestone() != null) {
				key = Issue.getMilestone().getTitle();
			}

			List<GitIssue> milestoneIssues = gitDump.issueMilestoneMap.get(key);

			if (!exportDump.issueMap.containsKey(key)) {
				exportDump.issueMap.put(key, new ArrayList<ExportableIssue>());

			}

			Issue exportIssue = new Issue();

			exportIssue.setGitIssue(Issue);

			exportDump.issueMap.get(key).add(exportIssue);
			exportIssue.setZenIssue(zenMap.get(exportIssue.getNumber()));

			if (exportIssue.getIsBug())
			{
				exportDump.bugs.add(exportIssue);
			}
			
			if (exportIssue.getIs_epic()) {
				exportDump.epics.add(exportIssue);
			}

			exportDump.issues.add(exportIssue);
			
		}

		return exportDump;
	}
}
