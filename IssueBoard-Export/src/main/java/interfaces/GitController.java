package interfaces;

import java.io.IOException;

import model.GitDump;
import model.RepoInfo;

public interface GitController {

	void setRepoInfo(RepoInfo repo);

	GitDump getGitData() throws IOException;

}