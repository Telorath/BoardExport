package model.filtering;

import java.util.ArrayList;
import java.util.List;

import model.filtering.filters.Filter;

public class Filterer<T> {

	public List<T> filter(List<T> unfilteredList, Filter<T> filter)
	{
		List<T> filteredList = new ArrayList<>();
		
		for (T item : unfilteredList)
		{
			if (filter.matchesFilter(item))
			{
				filteredList.add(item);
			}
		}
		return filteredList;
	}
	
}
