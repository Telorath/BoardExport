package model.filtering;

import exceptions.FilterCreationException;
import model.filtering.filters.Filter;

public abstract class FilterGenerator<T> {

	public enum FilterType
	{
		UPDATED_AFTER
	}
	
	public abstract FilterType getFilterType();
	
	public abstract String getFilterString();
	
	public abstract Filter<T> generateFilter() throws FilterCreationException;
	
	public String toString()
	{
		switch (getFilterType())
		{
		case UPDATED_AFTER:
			return "Updated After";
		default:
			return "BAD FILTER";
		}
	}
	
}