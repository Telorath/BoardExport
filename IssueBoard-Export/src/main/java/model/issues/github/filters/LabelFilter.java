package model.issues.github.filters;

import model.filtering.filters.Filter;
import model.issues.github.Label;
import model.issues.interfaces.GitIssue;

public class LabelFilter<T extends GitIssue> implements Filter<T> {

	private String labelName;

	public LabelFilter(String labelName) {
		this.labelName = labelName;
	}

	@Override
	public boolean matchesFilter(T item) {
		for (Label label : item.getLabels()) {
			if (label.getName().equalsIgnoreCase(labelName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Has label matching \"%s\"", labelName);
	}

}
