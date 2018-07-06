package model.issues.github.filters.generators;

import exceptions.FilterCreationException;
import model.filtering.AbstractFilterGenerator;
import model.filtering.filters.Filter;
import model.issues.github.filters.LabelFilter;
import model.issues.interfaces.GitIssue;
import view.input.InputSource;

public class LabelFilterGenerator<T extends GitIssue> extends AbstractFilterGenerator<T> {

	public LabelFilterGenerator(InputSource<String> inputSource) {
		this.inputSource = inputSource;
	}

	@Override
	public Filter<T> generateFilter() throws FilterCreationException {
		return new LabelFilter<>(getFilterString());
	}

	@Override
	public FilterType getFilterType() {
		return FilterType.LABEL_FILTER;
	}

}
