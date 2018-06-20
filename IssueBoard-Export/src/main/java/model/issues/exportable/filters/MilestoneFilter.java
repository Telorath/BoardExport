package model.issues.exportable.filters;

import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;

public class MilestoneFilter implements Filter<ExportableIssue> {

	private final String milestoneTitle;
	
	public MilestoneFilter(String milestoneTitle)
	{
		this.milestoneTitle = milestoneTitle;
	}
	
	@Override
	public boolean matchesFilter(ExportableIssue item) {
		if (item.getMilestone() == null && milestoneTitle == null)
		{
			return true;
		}
		else if (item.getMilestone() == null)
		{
			return false;
		}
		return (item.getMilestone().getTitle().equalsIgnoreCase(milestoneTitle));
	}

}
