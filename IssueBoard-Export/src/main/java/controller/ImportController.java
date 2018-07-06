package controller;

import java.io.IOException;

import interfaces.GitController;
import interfaces.ZenController;
import model.RepoInfo;
import model.ZenDump;
import model.ZenhubInfo;
import service.ExportableService;
import service.LocalDataService;
import service.MainOutputService;
import service.factories.ObjectFactory;

public class ImportController {
	private LocalDataService localDataService;
	private MainOutputService mainOutputService;
	private ObjectFactory objectFactory;
	private ExportableService exportableService;

	public void loadData(RepoInfo repoInfo, ZenhubInfo zenhubInfo) throws IOException {
		mainOutputService.write("Loading Data");

		GitController githubController = getObjectFactory().buildGitController();

		githubController.setRepoInfo(repoInfo);

		ZenController zenhubController = getObjectFactory().buildZenController();

		zenhubController.setZenhubInfo(zenhubInfo);

		localDataService.setGitDump(githubController.getGitData());

		ZenDump zenDump = new ZenDump();

		zenDump.setZenIssues(zenhubController.getZenIssues());
		
		localDataService.setZenDump(zenDump);

		zenDump.setReleases(zenhubController.getZenReleases());
		
		zenDump.correlateReleases();
		
		localDataService.setExportableDump(getExportableService().getExportables(getLocalDataService().getGitDump(),
				getLocalDataService().getZenDump().getZenIssues()));

	}

	public LocalDataService getLocalDataService() {
		return localDataService;
	}

	public void setLocalDataService(LocalDataService localDataService) {
		this.localDataService = localDataService;
	}

	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	public MainOutputService getMainOutputService() {
		return mainOutputService;
	}

	public void setMainOutputService(MainOutputService mainOutputService) {
		this.mainOutputService = mainOutputService;
	}

	public ExportableService getExportableService() {
		return exportableService;
	}

	public void setExportableService(ExportableService exportableService) {
		this.exportableService = exportableService;
	}

}
