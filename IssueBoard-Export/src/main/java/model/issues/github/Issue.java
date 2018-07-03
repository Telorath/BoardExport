package model.issues.github;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.issues.interfaces.GitIssue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue implements GitIssue {
	private Integer id;
	private String html_url;
	private Integer number;
	private String state;
	private String title;
	private String body;
	private User user;
	private List<Label> labels;
	private List<User> assignees;
	private Milestone milestone;
	private Date updated_At;
	private Date created_At;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#getId()
	 */
	public Integer getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#getHtml_url()
	 */
	public String getHtml_url() {
		return html_url;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#setHtml_url(java.lang.String)
	 */
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#getNumber()
	 */
	public Integer getNumber() {
		return number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#setNumber(java.lang.Integer)
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#getState()
	 */
	public String getState() {
		return state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#setState(java.lang.String)
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#getTitle()
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#setTitle(java.lang.String)
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#getBody()
	 */
	public String getBody() {
		return "\'" + body + "\'";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#setBody(java.lang.String)
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#getUser()
	 */
	public User getUser() {
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#setUser(model.issues.github.User)
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#getLabels()
	 */
	public List<Label> getLabels() {
		return labels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * model.issues.github.gitIssue#setLabels(model.issues.github.LabelList)
	 */
	@Override
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.github.gitIssue#getMilestone()
	 */
	public Milestone getMilestone() {
		return milestone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * model.issues.github.gitIssue#setMilestone(model.issues.github.Milestone)
	 */
	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

	@Override
	public List<User> getAssignees() {
		return assignees;
	}

	@Override
	public void setAssignees(List<User> assignees) {
		this.assignees = assignees;
	}

	@Override
	public String getPriority() {
		for (Label label : labels) {
			if (label.getName().equalsIgnoreCase("Priority - Low")) {
				return "Low Priority";
			}
			if (label.getName().equalsIgnoreCase("Priority - Medium")) {
				return "Medium Priority";
			}
			if (label.getName().equalsIgnoreCase("Priority - High")) {
				return "High Priority";
			}

		}
		return "Unassigned Priority";
	}

	@Override
	public String getSeverity() {
		for (Label label : labels) {
			if (label.getName().equalsIgnoreCase("Bug - Low Severity")) {
				return "Low Severity";
			}
			if (label.getName().equalsIgnoreCase("Bug - Medium Severity")) {
				return "Medium Severity";
			}
			if (label.getName().equalsIgnoreCase("Bug - High Severity")) {
				return "High Severity";
			}
		}
		return "Unassigned Severity";
	}

	@Override
	public Boolean getIsBug() {
		for (Label label : getLabels()) {
			if (label.getName().equalsIgnoreCase("bug")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Date getUpdated_at() {
		return updated_At;
	}

	@Override
	public void setUpdated_at(Date updated_At) {
		this.updated_At = updated_At;
	}

	@Override
	public Date getCreated_at() {
return created_At;
	}

	@Override
	public void setCreated_at(Date created_at) {
		created_At = created_at;
	}

}
