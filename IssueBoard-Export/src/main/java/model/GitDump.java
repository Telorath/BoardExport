package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.issues.interfaces.GitIssue;
import model.issues.interfaces.GitMilestone;

public class GitDump {
	public final List<GitMilestone> milestones = new ArrayList<>();
	public final List<GitIssue> issues = new ArrayList<>();
	
	public final Map<String, List<GitIssue>> issueMilestoneMap = new HashMap<>();
	
}
