package model.issues.exportable;

import model.issues.github.Label;

public class ExportableSeverityComparator extends ExportableIssueComparator {
	
	public static final String SEVERITY_LOW = "Bug - Low Severity";
	public static final String SEVERITY_MEDIUM = "Bug - Medium Severity";
	public static final String SEVERITY_HIGH = "Bug - High Severity";
	
	private Integer getSeverityNumber(ExportableIssue issue)
	{
		for (Label label : issue.getLabels())
		{
			if (label.getName().equalsIgnoreCase(SEVERITY_LOW))
			{
				return 1;
			}
			if (label.getName().equalsIgnoreCase(SEVERITY_MEDIUM))
			{
				return 2;
			}
			if (label.getName().equalsIgnoreCase(SEVERITY_HIGH))
			{
				return 3;
			}
		}
		
		return 0;
		
	}
	
	@Override
	public int compare(ExportableIssue o1, ExportableIssue o2) {

		Integer severityOne = getSeverityNumber(o1);
		Integer severityTwo = getSeverityNumber(o2);
		
		if (!severityOne.equals(severityTwo))
		{
			//Largest severity to smallest
			return severityTwo.compareTo(severityOne);
		}

		return super.compare(o1, o2);
		
	}

}
