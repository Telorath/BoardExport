package model.issues.interfaces;

import model.issues.zenhub.Estimate;

public interface ZenIssue {

	Integer getIssue_number();

	void setIssue_number(Integer issueNumber);

	Boolean getIs_epic();

	void setIs_epic(Boolean is_epic);

	Estimate getEstimate();

	void setEstimate(Estimate estimate);

	Integer getPosition();

	void setPosition(Integer position);

	String getPipeline();
	
	void setPipeline(String pipeline);
	
}