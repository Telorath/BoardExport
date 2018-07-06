package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.FilterCreationException;
import model.filtering.FilterGenerator;
import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;
import view.input.InputSource;
import view.output.OutputTarget;

public class AddFilterAction implements ActionListener {
	private OutputTarget<Filter<ExportableIssue>> filterList;
	private InputSource<FilterGenerator<ExportableIssue>> filterGeneratorInput;
	private OutputTarget<String> errorOutput;

	public AddFilterAction(OutputTarget<Filter<ExportableIssue>> filterList,
			InputSource<FilterGenerator<ExportableIssue>> filterGeneratorInput, OutputTarget<String> errorOutput) {
		this.filterList = filterList;
		this.filterGeneratorInput = filterGeneratorInput;
		this.errorOutput = errorOutput;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			filterList.write(filterGeneratorInput.getInput().generateFilter());
		} catch (FilterCreationException e1) {
			errorOutput.write(e1.getMessage());
		}

	}

}
