package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;
import view.io.IOListTarget;
import view.output.OutputTarget;

public class RemoveFilterAction implements ActionListener {

	private OutputTarget<String> errorOutput;
	private IOListTarget<Filter<ExportableIssue>> filterList;

	public RemoveFilterAction(IOListTarget<Filter<ExportableIssue>> filterList, OutputTarget<String> errorOutput) {
		this.errorOutput = errorOutput;
		this.filterList = filterList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (filterList.getInput() == null) {
			errorOutput.write("No filter selected to remove");
			return;
		}

		List<Filter<ExportableIssue>> values = filterList.getInputList();

		for (Filter<ExportableIssue> filter : values) {
			filterList.remove(filter);
		}

	}

}
