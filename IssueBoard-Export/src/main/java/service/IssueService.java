package service;

import java.io.IOException;

import model.http.HttpRequest;
import model.issues.interfaces.GitMilestone;

public interface IssueService {
	public HttpRequest getIssueByMilestoneRequest(GitMilestone milestone) throws IOException;

	public HttpRequest getAllIssuesRequest(Integer page) throws IOException;

}
