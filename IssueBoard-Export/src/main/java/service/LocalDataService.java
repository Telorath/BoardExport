package service;

import java.util.List;

import model.GitDump;
import model.issues.exportable.ExportableDump;
import model.issues.interfaces.ZenIssue;

public class LocalDataService {

	private GitDump gitDump;
	private List<ZenIssue> zenDump;
	private ExportableDump exportableDump;

	public void setGitDump(GitDump gitDump) {
		this.gitDump = gitDump;
	}

	public void setZenDump(List<ZenIssue> zenDump) {
		this.zenDump = zenDump;
	}

	public void setExportableDump(ExportableDump exportableDump) {
		this.exportableDump = exportableDump;
	}

	public GitDump getGitDump() {
		return gitDump;
	}

	public List<ZenIssue> getZenDump() {
		return zenDump;
	}

	public ExportableDump getExportableDump() {
		return exportableDump;
	}

}
