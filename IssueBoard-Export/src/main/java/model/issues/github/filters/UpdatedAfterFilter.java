package model.issues.github.filters;

import java.util.Date;

import model.filtering.filters.Filter;
import model.issues.interfaces.GitIssue;

public class UpdatedAfterFilter<T extends GitIssue> implements Filter<T> {

	private Date dateAfter;

	public UpdatedAfterFilter(Date dateAfter) {
		this.dateAfter = dateAfter;
	}

	@Override
	public boolean matchesFilter(T item) {
		if (item.getUpdated_at() == null) {
			return false;
		}
		return item.getUpdated_at().after(dateAfter);
	}

	@Override
	public String toString() {
		return String.format("Updated After %s", dateAfter.toString());
	}

}
