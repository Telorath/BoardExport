package service;

import java.util.List;

import model.GitDump;
import model.ZenDump;
import model.issues.exportable.ExportableDump;
import model.issues.interfaces.ZenIssue;

public class LocalDataService {

	private GitDump gitDump;
	private ZenDump zenDump;
	private ExportableDump exportableDump;

	public void setGitDump(GitDump gitDump) {
		this.gitDump = gitDump;
	}

	public void setZenDump(ZenDump zenDump) {
		this.zenDump = zenDump;
	}

	public void setExportableDump(ExportableDump exportableDump) {
		this.exportableDump = exportableDump;
	}

	public GitDump getGitDump() {
		return gitDump;
	}

	public ZenDump getZenDump() {
		return zenDump;
	}

	public ExportableDump getExportableDump() {
		return exportableDump;
	}

}
