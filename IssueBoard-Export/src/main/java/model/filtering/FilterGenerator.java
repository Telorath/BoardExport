package model.filtering;

import exceptions.FilterCreationException;
import model.filtering.filters.Filter;

public interface FilterGenerator<T> {

	Filter<T> generateFilter() throws FilterCreationException;

}