package model.issues.github;

import java.util.Comparator;

import model.issues.interfaces.GitIssue;

public class GitIssueComparator implements Comparator<GitIssue> {

	@Override
	public int compare(GitIssue o1, GitIssue o2) {
		return o1.getNumber().compareTo(o2.getNumber());
	}

	
	
}
