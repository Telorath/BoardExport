package controller.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.ZenController;
import model.ZenhubInfo;
import model.issues.interfaces.ZenIssue;
import model.issues.zenhub.Release;
import service.testing.TestRepoService;

public class TestZenController implements ZenController {

	private TestRepoService repo;

	@Override
	public List<ZenIssue> getZenIssues() throws IOException {
		return getRepo().getZenIssues();
	}

	@Override
	public ZenhubInfo getZenhubInfo() {
		return new ZenhubInfo();
	}

	@Override
	public void setZenhubInfo(ZenhubInfo zenhubInfo) {
		// Do nothing
	}

	public TestRepoService getRepo() {
		return repo;
	}

	public void setRepo(TestRepoService repo) {
		this.repo = repo;
	}

	@Override
	public List<Release> getZenReleases() throws IOException {
		return new ArrayList<>();
	}

}
