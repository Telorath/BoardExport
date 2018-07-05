package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.ListModel;

import controller.MainExportController;
import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;
import view.output.OutputTarget;

public class ExportAction implements ActionListener {

	private MainExportController mainExportController;

	private JList<Filter<ExportableIssue>> filterList;
	
	private OutputTarget errorOutput;

	public ExportAction(MainExportController mainExportController, JList<Filter<ExportableIssue>> filterList) {
		this.mainExportController = mainExportController;
		this.filterList = filterList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			ListModel<Filter<ExportableIssue>> filterModel = filterList.getModel();

			List<Filter<ExportableIssue>> activeFilters = new ArrayList<>();

			for (int i = 0; i < filterModel.getSize(); i++) {
				activeFilters.add(filterModel.getElementAt(i));
			}

			mainExportController.defaultControlFlow(activeFilters);
		} catch (IOException e1) {

			errorOutput.printLine(e1.getMessage());
			
		}

	}

}
