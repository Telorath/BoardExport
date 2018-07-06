package model.issues.zenhub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseIssueReference {
	Integer issue_number;

	public Integer getIssue_number() {
		return issue_number;
	}

	public void setIssue_number(Integer issue_number) {
		this.issue_number = issue_number;
	}
}
