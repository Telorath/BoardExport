package service;

import java.io.IOException;
import java.net.HttpURLConnection;

import model.RepoInfo;
import model.http.HttpRequest;
import model.issues.interfaces.GitMilestone;

public class GithubService extends AbstractHttpService implements MilestoneService, IssueService {

	public static final String API_URL = "https://api.github.com";

	public static final String REPOS = "/repos/";

	public static final String MILESTONES = "/milestones";

	public static final String ISSUES = "/issues";

	private RepoInfo repoInfo = null;

	public void setRepoInfo(RepoInfo repoInfo) {
		this.repoInfo = repoInfo;
	}

	public RepoInfo getRepoInfo() {
		return repoInfo;
	}

	public boolean getIsReady() {
		return repoInfo != null;
	}

	public GithubService() {
	}

	public HttpRequest getMilestoneRequest() throws IOException {
		return getConnection(getMilestoneUrl());
	}

	public HttpRequest getIssueByMilestoneRequest(GitMilestone milestone) throws IOException {

		return getConnection(getIssueMilestoneUrl(milestone));

	}

	@Override
	public HttpRequest getAllIssuesRequest(Integer page) throws IOException {
		return getConnection(getIssuePageURL(page));
	}

	@Override
	public void setConnectionAuthenticationProperty(HttpURLConnection connection) {

		connection.setRequestProperty("Authorization", "token " + getRepoInfo().getoAuthToken());

	}

	private String getRepoUrl() {
		return API_URL + REPOS + getRepoInfo().getRepoOwner() + "/" + getRepoInfo().getRepoName();
	}

	public String getMilestoneUrl() {
		return getRepoUrl() + MILESTONES;
	}

	public String getIssueUrl() {
		return getRepoUrl() + ISSUES;
	}

	public String getIssuePageURL(Integer pageNumber) {
		return getIssueUrl() + "?page=" + pageNumber.toString() + "&per_page=100";
	}

	public String getIssueMilestoneUrl(GitMilestone milestone) {
		return getIssueUrl() + "?milestone=" + milestone.getNumber();
	}

}
