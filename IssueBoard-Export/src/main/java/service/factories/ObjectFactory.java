package service.factories;

import controller.GithubController;
import controller.ZenhubController;
import interfaces.GitController;
import interfaces.ZenController;
import service.IssueWriter;

public class ObjectFactory {
	private ServiceFactory serviceFactory;

	public void setServiceFactory(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	public GitController buildGitController()
	{
		GithubController controller = new GithubController();
		controller.setGithubService(getServiceFactory().getGithubService());
		return controller;
	}
	
	public ZenController buildZenController()
	{
		ZenhubController controller = new ZenhubController();
		controller.setZenhubService(getServiceFactory().getZenhubService());
		return controller;
	}

	public IssueWriter buildIssueWriter()
	{
		IssueWriter writer = new IssueWriter();
		writer.setEntryService(getServiceFactory().getEntryService());
		return writer;
	}

	public ServiceFactory getServiceFactory() {
		return serviceFactory;
	}
	
}
