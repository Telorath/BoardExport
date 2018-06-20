package model.filtering;

import java.util.ArrayList;
import java.util.List;

import model.filtering.filters.Filter;

public class FilteredList<T> {
	private final List<T> originalList;

	private List<T> filteredList;

	private List<Filter<T>> filters = new ArrayList<>();

	private Filterer<T> filterer = new Filterer<>();

	public FilteredList(List<T> original) {
		originalList = original;
		filteredList = new ArrayList<>(originalList);
	}

	private void applyFilter(Filter<T> filter) {
		filteredList = filterer.filter(filteredList, filter);
	}

	public void addFilter(Filter<T> filter) {
		filters.add(filter);
		applyFilter(filter);
	}

	public void reFilter() {
		filteredList = new ArrayList<>(originalList);

		for (Filter<T> filter : filters) {
			applyFilter(filter);
		}

	}

	public void clearFilters()
	{
		filters = new ArrayList<>();
		reFilter();
	}
	
	public void removeFilter(Filter<T> filter) {
		filters.remove(filter);
		reFilter();
	}

	public T get(int i) {
		return filteredList.get(i);
	}
	
	public List<T> getFiltered()
	{
		return filteredList;
	}
	
}