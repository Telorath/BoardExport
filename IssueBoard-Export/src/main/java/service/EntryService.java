package service;

import java.util.List;

import csvFormatter.model.Entry;
import model.issues.exportable.ExportableIssue;
import model.issues.github.Label;
import model.issues.github.User;

public class EntryService {

	private String getAssigneeString(List<User> assignees) {
		if (assignees == null || assignees.isEmpty()) {
			return "";
		}
		StringBuilder assigneeString = new StringBuilder();

		for (User user : assignees) {
			assigneeString.append("[" + user.getLogin() + "]");
		}

		return assigneeString.toString();

	}

	private String getLabelString(List<Label> labels) {
		if (labels == null) {
			return "";
		}
		StringBuilder assigneeString = new StringBuilder();

		for (Label label : labels) {
			assigneeString.append("[" + label.getName() + "]");
		}

		return assigneeString.toString();

	}

	public Entry convertToEntry(ExportableIssue issue) {

		Entry entry = new Entry();

		entry.addProperty("number", issue.getNumber().toString());

		entry.addProperty("title", issue.getTitle());

		entry.addProperty("pipeline", issue.getPipeline());

		entry.addProperty("user", issue.getUser().getLogin());

		entry.addProperty("state", issue.getState());

		StringBuilder bodyString = new StringBuilder();
		
		bodyString.append(issue.getBody().replaceAll("\"", ""));
		
		if (bodyString.length() > 1000)
		{
			bodyString.setLength(1000);
			
			bodyString.append("(Truncated for Length, see link)");
		}
		
		entry.addProperty("body", bodyString.toString());
		
		String issueType;

		if (issue.getIs_epic()) {
			issueType = "Epic";
		} else {
			issueType = "Issue";
		}

		entry.addProperty("issueType", issueType);

		if (issue.getEstimate() != null) {
			entry.addProperty("estimate", issue.getEstimate().getValue().toString());
		}

		String assigneeString = getAssigneeString(issue.getAssignees());

		entry.addProperty("assignees", assigneeString);

		String labelString = getLabelString(issue.getLabels());

		entry.addProperty("labels", labelString);

		if (issue.getMilestone() != null) {
			entry.addProperty("milestone", issue.getMilestone().getTitle());
		}

		entry.addProperty("priority", issue.getPriority());

		entry.addProperty("severity", issue.getSeverity());

		entry.addProperty("url", issue.getHtml_url());

		return entry;
	}

}
