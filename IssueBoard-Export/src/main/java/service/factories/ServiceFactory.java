package service.factories;

import controller.MainExportController;
import service.CalendarDateService;
import service.DateService;
import service.EntryService;
import service.ExportableService;
import service.FormatService;
import service.GithubService;
import service.MainOutputService;
import service.ZenhubService;
import service.testing.TestRepoService;
import view.output.ConsoleOutputTarget;

public class ServiceFactory {

	protected ObjectFactory objectFactory;
	protected FormatService formatService;
	protected GithubService githubService;
	protected ZenhubService zenhubService;
	protected ExportableService exportableService;
	protected EntryService entryService;
	protected MainExportController mainExportController;
	protected TestRepoService repoService;
	protected DateService dateService;
	protected MainOutputService mainOutputService;

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
		if (exportableService == null) {
			exportableService = new ExportableService();
		}
		return exportableService;
	}

	public EntryService getEntryService() {
		if (entryService == null) {
			entryService = new EntryService();
		}
		return entryService;
	}

	public TestRepoService getTestRepoService() {
		if (repoService == null) {
			repoService = new TestRepoService(getDateService());
		}
		return repoService;
	}

	public ObjectFactory getObjectFactory() {
		if (objectFactory == null) {
			objectFactory = initializeObjectFactory();
		}
		return objectFactory;
	}

	public MainExportController getMainExportController() {
		if (mainExportController == null) {
			mainExportController = initializeMainExportController();
		}
		return mainExportController;
	}

	public DateService getDateService() {
		if (dateService == null) {
			dateService = initializeDateService();
		}
		return dateService;

	}

	protected DateService initializeDateService() {
		return new CalendarDateService();
	}

	public MainOutputService getMainOutputService() {

		if (mainOutputService == null) {
			mainOutputService = initializeMainOutputService();
		}

		return mainOutputService;

	}

	protected MainOutputService initializeMainOutputService() {

		MainOutputService service = new MainOutputService();

		service.setOutputTarget(new ConsoleOutputTarget());

		return service;
	}

	protected ZenhubService initializeZenhubService() {
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
		exportController.setMainOutputService(getMainOutputService());

		return exportController;
	}

}
