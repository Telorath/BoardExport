package model.filtering;

import model.filtering.filters.Filter;

public abstract class FilterGenerator<T> {

	public abstract String getFilterString();
	
	public abstract Filter<T> generateFilter();
	
}