package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;
import model.issues.github.filters.UpdatedAfterFilter;
import service.DateService;
import view.output.OutputTarget;

public class AddUpdatedAfterFilterAction implements ActionListener {

	private JList<Filter<ExportableIssue>> filterList;
	private JTextField dateField;
	private OutputTarget errorOutput;
	private DateService dateService;

	public AddUpdatedAfterFilterAction(JList<Filter<ExportableIssue>> filterList, JTextField dateField,
			OutputTarget errorOutput, DateService dateService) {
		this.filterList = filterList;
		this.dateField = dateField;
		this.errorOutput = errorOutput;
		this.dateService = dateService;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Date dateAfter = dateService.parseDate(dateField.getText());
			DefaultListModel<Filter<ExportableIssue>> oldFilters = (DefaultListModel<Filter<ExportableIssue>>) filterList
					.getModel();
			oldFilters.addElement(new UpdatedAfterFilter<ExportableIssue>(dateAfter));
		} catch (ParseException e1) {
			errorOutput.printLine(String.format("The string %s cannot be converted to a date!", dateField.getText()));
		}
	}

}
