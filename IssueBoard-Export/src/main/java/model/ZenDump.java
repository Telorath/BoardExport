package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.issues.interfaces.ZenIssue;
import model.issues.zenhub.Release;
import model.issues.zenhub.ReleaseIssueReference;

public class ZenDump {
	List<ZenIssue> zenIssues;

	List<Release> releases;

	public void correlateReleases() {
		Map<Integer, ZenIssue> issueMap = new HashMap<>();

		for (ZenIssue issue : zenIssues) {
			issueMap.put(issue.getIssue_number(), issue);
		}

		for (Release release : releases) {
			for (ReleaseIssueReference issueReference : release.getIssueReferences()) {
				ZenIssue issue = issueMap.get(issueReference.getIssue_number());
				if (issue != null)
				{
					issue.setRelease(release);					
				}
			}
		}

	}

	public List<ZenIssue> getZenIssues() {
		return zenIssues;
	}

	public void setZenIssues(List<ZenIssue> zenIssues) {
		this.zenIssues = zenIssues;
	}

	public List<Release> getReleases() {
		return releases;
	}

	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}
}
