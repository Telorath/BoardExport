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

	class Runner implements Runnable
	{
		public void run()
		{
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
	
	public ExportAction(MainExportController mainExportController, JList<Filter<ExportableIssue>> filterList, OutputTarget errorOutput) {
		this.mainExportController = mainExportController;
		this.filterList = filterList;
		this.errorOutput = errorOutput;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (mainExportController.isWorking())
		{
			errorOutput.printLine("Already working!");
		}
		else
		{
			Runner runner = new Runner();
			new Thread(runner).start();
		}

	}

}
