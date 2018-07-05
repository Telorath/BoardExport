package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;
import view.output.OutputTarget;

public class RemoveFilterAction implements ActionListener {

	private OutputTarget errorOutput;
	private JList<Filter<ExportableIssue>> filterList;

	public RemoveFilterAction(JList<Filter<ExportableIssue>> filterList, OutputTarget errorOutput) {
		this.errorOutput = errorOutput;
		this.filterList = filterList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (filterList.getSelectedIndex() < 0) {
			errorOutput.printLine("No filter selected to remove");
			return;
		}

		DefaultListModel<Filter<ExportableIssue>> filterModel = (DefaultListModel<Filter<ExportableIssue>>) filterList
				.getModel();

		List<Filter<ExportableIssue>> values = filterList.getSelectedValuesList();

		for (Filter<ExportableIssue> filter : values) {
			filterModel.removeElement(filter);
		}

	}

}
