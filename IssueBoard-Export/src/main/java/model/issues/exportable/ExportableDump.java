package model.issues.exportable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.issues.interfaces.GitMilestone;

public class ExportableDump {
	
	public final List<ExportableIssue> issues = new ArrayList<>();
	
	public final List<GitMilestone> milestoneList = new ArrayList<>();
	
	public final Map<String, List<ExportableIssue>> issueMap = new HashMap<>();
	
	public final List<ExportableIssue> epics = new ArrayList<>();
	
	public final List<ExportableIssue> bugs = new ArrayList<>();
	
}
