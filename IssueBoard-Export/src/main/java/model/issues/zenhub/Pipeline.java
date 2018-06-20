package model.issues.zenhub;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pipeline {
	private String id;
	private String name;
	private List<Issue> issues;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Issue> getIssues() {
		return issues;
	}
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}	
}
