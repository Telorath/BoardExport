package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import interfaces.ZenController;
import model.ZenhubInfo;
import model.http.HttpRequest;
import model.issues.interfaces.ZenIssue;
import model.issues.zenhub.Board;
import model.issues.zenhub.Issue;
import model.issues.zenhub.IssueReferenceList;
import model.issues.zenhub.Pipeline;
import model.issues.zenhub.Release;
import model.issues.zenhub.ReleaseList;
import service.ZenhubService;

public class ZenhubController implements ZenController {

	private ZenhubService zenhubService;

	private ZenhubInfo zenhubInfo;

	private void getIssuesForRelease(Release release) throws IOException
	{

		HttpRequest request = zenhubService.getReleaseIssues(release.getRelease_id());

		String json = request.getResponseString();

		ObjectMapper mapper = new ObjectMapper();

		release.setIssueReferences(mapper.readValue(json, IssueReferenceList.class));
	}
	
	public List<Release> getZenReleases() throws IOException {

		HttpRequest request = zenhubService.getReleasesRequest();

		String json = request.getResponseString();

		ObjectMapper mapper = new ObjectMapper();

		List<Release> releases = mapper.readValue(json, ReleaseList.class);

		for (Release release : releases)
		{
			getIssuesForRelease(release);
		}
		
		return releases;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ZenController#getZenIssues()
	 */
	@Override
	public List<ZenIssue> getZenIssues() throws IOException {

		zenhubService.setZenhubInfo(zenhubInfo);

		HttpRequest request = zenhubService.getBoardRequest();

		String json = request.getResponseString();

		ObjectMapper mapper = new ObjectMapper();

		List<ZenIssue> issues = new ArrayList<>();

		Board board = mapper.readValue(json, Board.class);

		for (Pipeline pipeline : board.getPipelines()) {
			for (Issue issue : pipeline.getIssues()) {
				if (issue.getIssue_number() == null) {
					continue;
				}
				issue.setPipeline(pipeline.getName());
				issues.add(issue);
			}
		}

		return issues;

	}

	public ZenhubService getZenhubService() {
		return zenhubService;
	}

	public void setZenhubService(ZenhubService zenhubService) {
		this.zenhubService = zenhubService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ZenController#getZenhubInfo()
	 */
	@Override
	public ZenhubInfo getZenhubInfo() {
		return zenhubInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ZenController#setZenhubInfo(model.ZenhubInfo)
	 */
	@Override
	public void setZenhubInfo(ZenhubInfo zenhubInfo) {
		this.zenhubInfo = zenhubInfo;
	}

}
