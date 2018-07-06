package model.issues.zenhub;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Release {
	private String release_id;
	private String title;
	List<ReleaseIssueReference> issueReferences;

	public String getRelease_id() {
		return release_id;
	}

	public void setRelease_id(String release_id) {
		this.release_id = release_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ReleaseIssueReference> getIssueReferences() {
		return issueReferences;
	}

	public void setIssueReferences(List<ReleaseIssueReference> issueReferences) {
		this.issueReferences = issueReferences;
	}
}
