package model.issues.github.filters.generators;

import exceptions.DateParseException;
import exceptions.FilterCreationException;
import model.filtering.AbstractFilterGenerator;
import model.filtering.filters.Filter;
import model.issues.github.filters.UpdatedAfterFilter;
import model.issues.interfaces.GitIssue;
import service.DateService;
import view.input.InputSource;

public class UpdatedAfterFilterGenerator<T extends GitIssue> extends AbstractFilterGenerator<T> {
	
	InputSource<String> inputSource;
	DateService dateService;

	public UpdatedAfterFilterGenerator(InputSource<String> inputSource, DateService dateService)
	{
		this.inputSource = inputSource;
		this.dateService = dateService;
	}
	
	@Override
	public FilterType getFilterType() {
		return FilterType.UPDATED_AFTER;
	}
	
	@Override
	public String getFilterString() {
		return inputSource.getInput();
	}

	@Override
	public Filter<T> generateFilter() throws FilterCreationException {
			try {
				return new UpdatedAfterFilter<>(dateService.parseDate(getFilterString()));
			} catch (DateParseException e) {
				throw new FilterCreationException(e.getMessage());
			}
	}

}
