package model.issues.zenhub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.issues.interfaces.ZenIssue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue implements ZenIssue {
	private Integer issue_number;
	private Boolean is_epic;
	private Estimate estimate;
	private Integer position;
	private String pipeline;

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.zenhub.ZenIssue#getIssueNumber()
	 */
	public Integer getIssue_number() {
		return issue_number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.zenhub.ZenIssue#setIssueNumber(java.lang.Integer)
	 */
	public void setIssue_number(Integer issueNumber) {
		this.issue_number = issueNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.zenhub.ZenIssue#getIs_epic()
	 */
	public Boolean getIs_epic() {
		return is_epic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.zenhub.ZenIssue#setIs_epic(java.lang.Boolean)
	 */
	public void setIs_epic(Boolean is_epic) {
		this.is_epic = is_epic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.zenhub.ZenIssue#getEstimate()
	 */
	public Estimate getEstimate() {
		return estimate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * model.issues.zenhub.ZenIssue#setEstimate(model.issues.zenhub.Estimate)
	 */
	public void setEstimate(Estimate estimate) {
		this.estimate = estimate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.zenhub.ZenIssue#getPosition()
	 */
	public Integer getPosition() {
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.issues.zenhub.ZenIssue#setPosition(java.lang.Integer)
	 */
	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public String getPipeline() {
		return pipeline;
	}

	@Override
	public void setPipeline(String pipeline) {
		this.pipeline = pipeline;

	}
}
