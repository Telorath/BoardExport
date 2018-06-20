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
import model.issues.zenhub.Pipeline;
import service.BoardService;
import service.DataSourceService;
import service.ZenhubService;

public class ZenhubController implements ZenController {
	
	private ZenhubService zenhubService;
	
	private ZenhubInfo zenhubInfo;
	
	/* (non-Javadoc)
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

		for (Pipeline pipeline : board.getPipelines())
		{
			for (Issue issue : pipeline.getIssues())
			{
				if (issue.getIssue_number() == null)
				{
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

	/* (non-Javadoc)
	 * @see controller.ZenController#getZenhubInfo()
	 */
	@Override
	public ZenhubInfo getZenhubInfo() {
		return zenhubInfo;
	}

	/* (non-Javadoc)
	 * @see controller.ZenController#setZenhubInfo(model.ZenhubInfo)
	 */
	@Override
	public void setZenhubInfo(ZenhubInfo zenhubInfo) {
		this.zenhubInfo = zenhubInfo;
	}

}
