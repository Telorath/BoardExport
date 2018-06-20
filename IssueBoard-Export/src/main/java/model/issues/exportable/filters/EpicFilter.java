package model.issues.exportable.filters;

import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;

public class EpicFilter implements Filter<ExportableIssue> {

	@Override
	public boolean matchesFilter(ExportableIssue item) {
		return item.getIs_epic();
	}

}
