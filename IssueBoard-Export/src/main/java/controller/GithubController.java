package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import interfaces.GitController;
import model.GitDump;
import model.RepoInfo;
import model.http.HttpRequest;
import model.issues.github.IssueList;
import model.issues.github.MilestoneList;
import model.issues.interfaces.GitIssue;
import service.GithubService;

public class GithubController implements GitController {

	private GithubService githubService;

	private RepoInfo repoInfo;
	
	public void setGithubService(GithubService service) {
		githubService = service;
	}

	/* (non-Javadoc)
	 * @see controller.GitController#setRepoInfo(model.RepoInfo)
	 */
	@Override
	public void setRepoInfo(RepoInfo repo) { repoInfo = repo; }

	/* (non-Javadoc)
	 * @see controller.GitController#getGitData()
	 */
	@Override
	public GitDump getGitData() throws IOException
	{
		
		githubService.setRepoInfo(repoInfo);
		
		GitDump dump = new GitDump();

		Integer i = 1;
		
		ObjectMapper mapper = new ObjectMapper();

		while (true)
		{
			HttpRequest request = githubService.getAllIssuesRequest(i);
			String json = request.getResponseString();

			IssueList issues = mapper.readValue(json, IssueList.class);
			
			if (issues == null || issues.isEmpty())
			{
				break;
			}
			
			dump.issues.addAll(issues);
			
			i++;
			
		}
		
		HttpRequest request = githubService.getMilestoneRequest();

		String json = request.getResponseString();
		
		dump.milestones.addAll(mapper.readValue(json, MilestoneList.class));
		
		for (GitIssue issue : dump.issues)
		{
			String key = null;
			if (issue.getMilestone() != null)
			{
				key = issue.getMilestone().getTitle();
			}
			if (!dump.issueMilestoneMap.containsKey(key))
			{
				dump.issueMilestoneMap.put(key, new ArrayList<GitIssue>());
			}

			dump.issueMilestoneMap.get(key).add(issue);
			
		}
		return dump;		
	}
}