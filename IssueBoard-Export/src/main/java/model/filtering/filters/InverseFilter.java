package model.filtering.filters;

public class InverseFilter<T> implements Filter<T> {

	Filter<T> filter;
	
	public InverseFilter(Filter<T> filter)
	{
		this.filter = filter;
	}
	
	@Override
	public boolean matchesFilter(T item) {
		return !filter.matchesFilter(item);
	}

}
