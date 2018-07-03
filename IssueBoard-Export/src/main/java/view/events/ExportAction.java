package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import controller.MainExportController;
import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;

public class ExportAction implements ActionListener {

	private MainExportController mainExportController;

	public ExportAction(MainExportController mainExportController) {
		this.mainExportController = mainExportController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			mainExportController.defaultControlFlow(new ArrayList<Filter<ExportableIssue>>());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
