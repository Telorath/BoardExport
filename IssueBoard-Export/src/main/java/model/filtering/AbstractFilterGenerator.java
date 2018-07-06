package model.filtering;

import view.input.InputSource;

public abstract class AbstractFilterGenerator<T> implements FilterGenerator<T> {

	protected InputSource<String> inputSource;
	
	public enum FilterType {
		UPDATED_AFTER, CREATED_AFTER, LABEL_FILTER
	}

	public abstract FilterType getFilterType();

	public String getFilterString()
	{
		return inputSource.getInput();
	}

	public String toString() {
		switch (getFilterType()) {
		case UPDATED_AFTER:
			return "Updated After";
		case CREATED_AFTER:
			return "Created After";
		case LABEL_FILTER:
			return "Label Matching";
		default:
			return "BAD FILTER";
		}
	}

}