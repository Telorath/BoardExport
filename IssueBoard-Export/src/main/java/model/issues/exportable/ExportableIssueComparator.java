package model.issues.exportable;

import java.util.Comparator;

public class ExportableIssueComparator implements Comparator<ExportableIssue> {

	@Override
	public int compare(ExportableIssue o1, ExportableIssue o2) {
		if (o1.getIs_epic() != o2.getIs_epic())
		{
			if (o1.getIs_epic())
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
		
		return o1.getIssue_number().compareTo(o2.getIssue_number());
		
	}

}
