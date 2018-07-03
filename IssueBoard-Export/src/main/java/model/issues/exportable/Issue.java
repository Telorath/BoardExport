package model.issues.exportable;

import java.util.Date;
import java.util.List;

import model.issues.github.Label;
import model.issues.github.Milestone;
import model.issues.github.User;
import model.issues.interfaces.GitIssue;
import model.issues.interfaces.ZenIssue;
import model.issues.zenhub.Estimate;

public class Issue implements ExportableIssue {

	private GitIssue gitIssue;

	private ZenIssue zenIssue;

	@Override
	public List<User> getAssignees() {
		return gitIssue.getAssignees();
	}

	public String getBody() {
		return gitIssue.getBody();
	}

	public Estimate getEstimate() {
		return zenIssue.getEstimate();
	}

	public GitIssue getGitIssue() {
		return gitIssue;
	}

	public String getHtml_url() {
		return gitIssue.getHtml_url();
	}

	public Integer getId() {
		return gitIssue.getId();
	}

	public Boolean getIs_epic() {
		if (zenIssue.getIs_epic() == null) {
			return false;
		}
		return zenIssue.getIs_epic();
	}

	public Integer getIssue_number() {
		return gitIssue.getNumber();
	}

	public List<Label> getLabels() {
		return gitIssue.getLabels();
	}

	public Milestone getMilestone() {
		return gitIssue.getMilestone();
	}

	public Integer getNumber() {
		return gitIssue.getNumber();
	}

	public Integer getPosition() {
		return zenIssue.getPosition();
	}

	public String getState() {
		return gitIssue.getState();
	}

	public String getTitle() {
		return gitIssue.getTitle();
	}

	public User getUser() {
		return gitIssue.getUser();
	}

	public ZenIssue getZenIssue() {
		return zenIssue;
	}

	@Override
	public void setAssignees(List<User> assignees) {
		gitIssue.setAssignees(assignees);
	}

	public void setBody(String body) {
		gitIssue.setBody(body);
	}

	public void setEstimate(Estimate estimate) {
		zenIssue.setEstimate(estimate);
	}

	public void setGitIssue(GitIssue gitIssue) {
		this.gitIssue = gitIssue;
	}

	public void setHtml_url(String html_url) {
		gitIssue.setHtml_url(html_url);
	}

	public void setId(Integer id) {
		gitIssue.setId(id);
	}

	public void setIs_epic(Boolean is_epic) {
		zenIssue.setIs_epic(is_epic);
	}

	public void setIssue_number(Integer issueNumber) {
		gitIssue.setNumber(issueNumber);
		zenIssue.setIssue_number(issueNumber);
	}

	public void setLabels(List<Label> labels) {
		gitIssue.setLabels(labels);
	}

	public void setMilestone(Milestone milestone) {
		gitIssue.setMilestone(milestone);
	}

	public void setNumber(Integer number) {
		gitIssue.setNumber(number);
		zenIssue.setIssue_number(number);
	}

	public void setPosition(Integer position) {
		zenIssue.setPosition(position);
	}

	public void setState(String state) {
		gitIssue.setState(state);
	}

	public void setTitle(String title) {
		gitIssue.setTitle(title);
	}

	public void setUser(User user) {
		gitIssue.setUser(user);
	}

	public void setZenIssue(ZenIssue zenIssue) {
		this.zenIssue = zenIssue;
	}

	public String getPipeline()
	{
		return zenIssue.getPipeline();
	}
	
	public void setPipeline(String pipeline)
	{
		zenIssue.setPipeline(pipeline);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		if (getIs_epic()) {
			stringBuilder.append(String.format("EPIC(#%s): ", getNumber()));
		} else {
			stringBuilder.append(String.format("ISSUE(#%s): ", getNumber()));
		}

		stringBuilder.append(getTitle());

		if (getEstimate() != null) {
			stringBuilder.append(String.format("(estimate: %s)", getEstimate()));
		} else {
			stringBuilder.append("(no estimate)");
		}

		return stringBuilder.toString();
	}

	@Override
	public String getPriority() {
		return gitIssue.getPriority();
	}

	@Override
	public String getSeverity() {
		return gitIssue.getSeverity();
	}

	@Override
	public Boolean getIsBug() {
		return gitIssue.getIsBug();
	}

	@Override
	public Date getUpdated_at() {
		return gitIssue.getUpdated_at();
	}

	@Override
	public void setUpdated_at(Date updated_At) {
		gitIssue.setUpdated_at(updated_At);
	}

	@Override
	public Date getCreated_at() {
		return gitIssue.getCreated_at();
	}

	@Override
	public void setCreated_at(Date created_at) {
		gitIssue.setCreated_at(created_at);
	}

}
