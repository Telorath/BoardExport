package controller.testing;

import java.io.IOException;

import interfaces.GitController;
import model.GitDump;
import model.RepoInfo;
import service.testing.TestRepoService;

public class TestGitController implements GitController {

	private TestRepoService repo;
	
	@Override
	public void setRepoInfo(RepoInfo repo) {
		// Do nothing: We don't actually use repo info.
	}

	@Override
	public GitDump getGitData() throws IOException {

		return getRepo().getGitDump();
		
	}

	public TestRepoService getRepo() {
		return repo;
	}

	public void setRepo(TestRepoService repo) {
		this.repo = repo;
	}

}
