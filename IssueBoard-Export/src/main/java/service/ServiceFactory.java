package service;

import controller.MainExportController;
import service.testing.TestRepoService;

public class ServiceFactory {
	protected ObjectFactory objectFactory;
	protected FormatService formatService;
	protected GithubService githubService;
	protected ZenhubService zenhubService;
	protected ExportableService exportableService;
	protected EntryService entryService;
	protected MainExportController mainExportController;
	protected TestRepoService repoService;
	
	public FormatService getFormatService() {
		if (formatService == null) {
			formatService = new FormatService();
		}
		return formatService;
	}

	public GithubService getGithubService() {
		if (githubService == null) {
			githubService = new GithubService();
		}
		return githubService;
	}

	public ZenhubService getZenhubService() {
		if (zenhubService == null) {
			zenhubService = initializeZenhubService();
		}
		return zenhubService;
	}

	public ExportableService getExportableService() {
		if (exportableService == null)
		{
			exportableService = new ExportableService();
		}
		return exportableService;
	}

	public EntryService getEntryService() {
		if (entryService == null)
		{
			entryService = new EntryService();
		}
		return entryService;
	}

	public TestRepoService getTestRepoService() {
		if (repoService == null) {
			repoService = new TestRepoService();
		}
		return repoService;
	}
	
	public ObjectFactory getObjectFactory() {
		if (objectFactory == null) {
			objectFactory = initializeObjectFactory();
		}
		return objectFactory;
	}

	public MainExportController getMainExportController()
	{
		if (mainExportController == null)
		{
			mainExportController = initializeMainExportController();
		}
		return mainExportController;
	}
	
	protected ZenhubService initializeZenhubService()
	{
		return new ZenhubService();
	}
	
	protected ObjectFactory initializeObjectFactory() {
		ObjectFactory factory = new ObjectFactory();
		factory.setServiceFactory(this);
		return factory;
	}

	protected MainExportController initializeMainExportController() {
		MainExportController exportController = new MainExportController();

		exportController.setEntryService(getEntryService());
		exportController.setExportableService(getExportableService());
		exportController.setFormatService(getFormatService());
		exportController.setObjectFactory(getObjectFactory());
		exportController.setIssueWriter(getObjectFactory().buildIssueWriter());
		
		return exportController;
	}

}
