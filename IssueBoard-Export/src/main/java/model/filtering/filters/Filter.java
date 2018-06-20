package model.filtering.filters;

public interface Filter<T> {
	public boolean matchesFilter(T item);
}
