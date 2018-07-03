package service.testing;

import java.util.ArrayList;
import java.util.List;

import model.GitDump;
import model.issues.exportable.Issue;
import model.issues.github.Label;
import model.issues.github.Milestone;
import model.issues.github.User;
import model.issues.interfaces.GitIssue;
import model.issues.interfaces.ZenIssue;
import service.DateService;

public class TestRepoService {

	private List<Milestone> milestones = new ArrayList<>();
	private List<model.issues.exportable.Issue> exportables = new ArrayList<>();
	private DateService dateService;

	public TestRepoService(DateService dateService) {
		this.dateService = dateService;
		setupMilestones();
		setupIssues();
	}

	private void setupMilestones() {
		for (int i = 0; i < 10; i++) {
			Milestone milestone = new Milestone();
			milestone.setId(i + 1);
			milestone.setNumber(i + 1);
			milestone.setState("Some State");
			milestone.setTitle("Test Milestone #" + (i + 1));

			milestones.add(milestone);

		}
	}

	private GitIssue buildGitIssue(int milestoneNumber, int issueNumber, int totalIssuesPerMilestone,
			Milestone milestone) {
		GitIssue issue = new model.issues.github.Issue();

		issue.setId(100 + milestoneNumber * totalIssuesPerMilestone + issueNumber);
		issue.setMilestone(milestone);
		issue.setNumber(100 + milestoneNumber * totalIssuesPerMilestone + issueNumber);
		issue.setTitle("Issue #" + (100 + milestoneNumber * totalIssuesPerMilestone + issueNumber));
		issue.setState("Open");
		issue.setHtml_url("Not a real issue");

		User user = new User();

		user.setLogin("TestUser");

		issue.setUser(user);

		List<Label> labelList = new ArrayList<>();

		Label label;

		switch (issueNumber) {
		case 1:
			label = new Label();
			label.setId(milestoneNumber * 10 + issueNumber);
			label.setName("Epic");
			labelList.add(label);
			issue.setUpdated_at(dateService.getToday());
			break;
		case 2:
			label = new Label();
			label.setId(milestoneNumber * 10 + issueNumber);
			label.setName("Bug");
			labelList.add(label);
			issue.setUpdated_at(dateService.getYesterday());
			break;
		default:
			issue.setUpdated_at(dateService.getLastWeek());
			break;
		}
		issue.setCreated_at(issue.getUpdated_at());
		issue.setLabels(labelList);
		return issue;
	}

	private ZenIssue buildZenIssue(int milestoneNumber, int issueNumber, int totalIssuesPerMilestone) {
		ZenIssue issue = new model.issues.zenhub.Issue();

		issue.setIssue_number(100 + milestoneNumber * totalIssuesPerMilestone + issueNumber);
		if (issueNumber == 1) {
			issue.setIs_epic(true);
		}
		issue.setPipeline("Open");
		return issue;

	}

	private void setupIssues() {
		for (int i = 0; i < milestones.size(); i++) {
			for (int j = 0; j < 3; j++) {

				Issue issue = new Issue();

				issue.setGitIssue(buildGitIssue(i, j, 3, milestones.get(i)));

				issue.setZenIssue(buildZenIssue(i, j, 3));

				exportables.add(issue);

			}
		}
	}

	public GitDump getGitDump() {

		GitDump out = new GitDump();

		for (Milestone milestone : milestones) {
			out.milestones.add(milestone);
		}
		for (Issue issue : exportables) {
			out.issues.add(issue.getGitIssue());
		}

		return out;

	}

	public List<ZenIssue> getZenIssues() {
		List<ZenIssue> issues = new ArrayList<>();

		for (Issue issue : exportables) {
			issues.add(issue.getZenIssue());
		}

		return issues;
	}

}
