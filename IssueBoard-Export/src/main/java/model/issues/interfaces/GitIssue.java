package model.issues.interfaces;

import java.util.Date;
import java.util.List;

import model.issues.github.Label;
import model.issues.github.Milestone;
import model.issues.github.User;

public interface GitIssue {

	Integer getId();

	void setId(Integer id);

	String getHtml_url();

	void setHtml_url(String html_url);

	Integer getNumber();

	void setNumber(Integer number);

	String getState();

	void setState(String state);

	String getTitle();

	void setTitle(String title);

	String getBody();

	void setBody(String body);

	User getUser();

	void setUser(User user);

	List<Label> getLabels();

	void setLabels(List<Label> labels);

	Milestone getMilestone();

	void setMilestone(Milestone milestone);

	List<User> getAssignees();

	void setAssignees(List<User> assignees);

	Boolean getIsBug();

	String getPriority();

	String getSeverity();

	Date getCreated_at();

	void setCreated_at(Date created_at);

	Date getUpdated_at();

	void setUpdated_at(Date updated_At);

}