package model.issues.github.filters.generators;

import exceptions.DateParseException;
import exceptions.FilterCreationException;
import model.filtering.AbstractFilterGenerator;
import model.filtering.filters.Filter;
import model.issues.github.filters.CreatedAfterFilter;
import model.issues.interfaces.GitIssue;
import service.DateService;
import view.input.InputSource;

public class CreatedAfterFilterGenerator<T extends GitIssue> extends AbstractFilterGenerator<T> {

	DateService dateService;

	public CreatedAfterFilterGenerator(InputSource<String> inputSource, DateService dateService) {
		this.inputSource = inputSource;
		this.dateService = dateService;
	}

	@Override
	public FilterType getFilterType() {
		return FilterType.CREATED_AFTER;
	}

	@Override
	public Filter<T> generateFilter() throws FilterCreationException {
		try {
			return new CreatedAfterFilter<>(dateService.parseDate(getFilterString()));
		} catch (DateParseException e) {
			throw new FilterCreationException(e.getMessage());
		}
	}
}