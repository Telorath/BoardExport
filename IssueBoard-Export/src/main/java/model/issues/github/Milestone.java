package model.issues.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.issues.interfaces.GitMilestone;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Milestone implements GitMilestone {
	private Integer id;
	private Integer number;
	private String state;
	private String title;
	private String description;
	private Integer open_issues;
	private Integer closed_issues;

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#getId()
	 */
	public Integer getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#getNumber()
	 */
	public Integer getNumber() {
		return number;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#setNumber(java.lang.Integer)
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#getState()
	 */
	public String getState() {
		return state;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#setState(java.lang.String)
	 */
	public void setState(String state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#getTitle()
	 */
	public String getTitle() {
		return title;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#setTitle(java.lang.String)
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#getOpen_issues()
	 */
	public Integer getOpen_issues() {
		return open_issues;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#setOpen_issues(java.lang.Integer)
	 */
	public void setOpen_issues(Integer open_issues) {
		this.open_issues = open_issues;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#getClosed_issues()
	 */
	public Integer getClosed_issues() {
		return closed_issues;
	}

	/* (non-Javadoc)
	 * @see model.issues.github.Miles#setClosed_issues(java.lang.Integer)
	 */
	public void setClosed_issues(Integer closed_issues) {
		this.closed_issues = closed_issues;
	}

	@Override
	public String toString()
	{
		return title + "(" + open_issues + " open)";
	}
	
}