package model.issues.interfaces;

public interface GitMilestone {

	Integer getId();

	void setId(Integer id);

	Integer getNumber();

	void setNumber(Integer number);

	String getState();

	void setState(String state);

	String getTitle();

	void setTitle(String title);

	String getDescription();

	void setDescription(String description);

	Integer getOpen_issues();

	void setOpen_issues(Integer open_issues);

	Integer getClosed_issues();

	void setClosed_issues(Integer closed_issues);

}