package model.issues.exportable.filters;

import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;

public class BugFilter implements Filter<ExportableIssue> {

	@Override
	public boolean matchesFilter(ExportableIssue item) {
		return item.getIsBug();
	}

}
