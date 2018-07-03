package model.issues.github.filters;

import java.util.Date;

import model.filtering.filters.Filter;
import model.issues.interfaces.GitIssue;

public class CreatedAfterFilter<T extends GitIssue> implements Filter<T> {

	Date dateAfter;

	public CreatedAfterFilter(Date dateAfter) {
		this.dateAfter = dateAfter;
	}

	@Override
	public boolean matchesFilter(T item) {
		return item.getCreated_at().after(dateAfter);
	}

}
