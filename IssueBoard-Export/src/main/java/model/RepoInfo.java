package model;

public class RepoInfo {
	private String repoName;
	private String repoOwner;
	private String oAuthToken;

	public RepoInfo() {
	};

	public RepoInfo(String repoName, String repoOwner, String oAuthToken) {
		this.repoName = repoName;
		this.repoOwner = repoOwner;
		this.oAuthToken = oAuthToken;
	}

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	public String getRepoOwner() {
		return repoOwner;
	}

	public void setRepoOwner(String repoOwner) {
		this.repoOwner = repoOwner;
	}

	public String getoAuthToken() {
		return oAuthToken;
	}

	public void setoAuthToken(String oAuthToken) {
		this.oAuthToken = oAuthToken;
	}
}
