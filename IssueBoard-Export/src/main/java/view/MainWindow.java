package view;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.filtering.AbstractFilterGenerator;
import model.filtering.FilterGenerator;
import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;
import model.issues.github.filters.generators.CreatedAfterFilterGenerator;
import model.issues.github.filters.generators.LabelFilterGenerator;
import model.issues.github.filters.generators.UpdatedAfterFilterGenerator;
import service.ServiceFactoryInitializer;
import service.factories.ServiceFactory;
import view.events.AddFilterAction;
import view.events.ExportAction;
import view.events.RemoveFilterAction;
import view.input.ComboBoxInputSource;
import view.input.TextFieldInputSource;
import view.io.JListIO;
import view.output.TextAreaOutput;

public class MainWindow {

	private ServiceFactory serviceFactory;

	private JFrame frmIssueBoardExporter;

	WindowState windowState;

	public class WindowState {
		private JButton exportButton;
		private JTextArea mainOutput;
		private JButton addFilterButton;
		private JButton removeFilterButton;
		private JList<Filter<ExportableIssue>> filterList;
		private JTextField FilterField;
		private JComboBox<FilterGenerator<ExportableIssue>> filterComboBox;

		public JComboBox<FilterGenerator<ExportableIssue>> getFilterComboBox() {
			return filterComboBox;
		}

		public JTextField getDateField() {
			return FilterField;
		}

		public JButton getExportButton() {
			return exportButton;
		}

		public JTextArea getMainOutput() {
			return mainOutput;
		}

		public JButton getAddFilterButton() {
			return addFilterButton;
		}

		public JButton getRemoveFilterButton() {
			return removeFilterButton;
		}

		public JList<Filter<ExportableIssue>> getFilterList() {
			return filterList;
		}

	}

	/**
	 * Launch the application.
	 */
	public static void invokeWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmIssueBoardExporter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setupFilterComboBox() {

		TextFieldInputSource filterInputText = new TextFieldInputSource(windowState.FilterField, true);

		windowState.filterComboBox.addItem(
				new UpdatedAfterFilterGenerator<ExportableIssue>(filterInputText, serviceFactory.getDateService()));

		windowState.filterComboBox.addItem(
				new CreatedAfterFilterGenerator<ExportableIssue>(filterInputText, serviceFactory.getDateService()));

		windowState.filterComboBox.addItem(new LabelFilterGenerator<ExportableIssue>(filterInputText));

	}

	/**
	 * Links all events to their respective buttons;
	 */
	private void linkEvents() {

		serviceFactory.getMainOutputService().setOutputTarget(new TextAreaOutput(windowState.mainOutput));

		windowState.exportButton.addActionListener(new ExportAction(serviceFactory.getMainExportController(),
				windowState.filterList, serviceFactory.getMainOutputService()));

		windowState.filterList.setModel(new DefaultListModel<Filter<ExportableIssue>>());

		windowState.addFilterButton
				.addActionListener(new AddFilterAction(new JListIO<Filter<ExportableIssue>>(windowState.filterList),
						new ComboBoxInputSource<>(windowState.filterComboBox), serviceFactory.getMainOutputService()));

		windowState.removeFilterButton.addActionListener(
				new RemoveFilterAction(new JListIO<>(windowState.filterList), serviceFactory.getMainOutputService()));
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		setupFilterComboBox();
		linkEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		serviceFactory = new ServiceFactoryInitializer().getServiceFactory();

		windowState = new WindowState();

		frmIssueBoardExporter = new JFrame();
		frmIssueBoardExporter.setTitle("Issue Board Exporter");
		frmIssueBoardExporter.setBounds(100, 100, 588, 368);
		frmIssueBoardExporter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIssueBoardExporter.getContentPane().setLayout(null);

		JButton btnexportButton = new JButton("Perform Export");
		btnexportButton.setBounds(10, 11, 110, 23);
		frmIssueBoardExporter.getContentPane().add(btnexportButton);
		windowState.exportButton = btnexportButton;

		JMenuBar menuBar = new JMenuBar();
		frmIssueBoardExporter.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Settings");
		menuBar.add(mnNewMenu);

		JMenuItem mntmCredentials = new JMenuItem("Credentials");
		mnNewMenu.add(mntmCredentials);

		JTextField textField = new JTextField();
		textField.setBounds(396, 74, 166, 20);
		frmIssueBoardExporter.getContentPane().add(textField);
		textField.setColumns(10);

		windowState.FilterField = textField;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 277, 78);
		frmIssueBoardExporter.getContentPane().add(scrollPane);

		JList<Filter<ExportableIssue>> list = new JList<>();
		scrollPane.setViewportView(list);

		windowState.filterList = list;

		JButton addFilterButton = new JButton("Add Filter");
		addFilterButton.setBounds(297, 43, 89, 23);
		frmIssueBoardExporter.getContentPane().add(addFilterButton);

		windowState.addFilterButton = addFilterButton;

		JButton removeFilterButton = new JButton("Remove Selected");
		removeFilterButton.setBounds(297, 100, 89, 23);
		frmIssueBoardExporter.getContentPane().add(removeFilterButton);

		windowState.removeFilterButton = removeFilterButton;

		JScrollPane textAreaScrollPane = new JScrollPane();
		textAreaScrollPane.setBounds(10, 193, 552, 104);
		frmIssueBoardExporter.getContentPane().add(textAreaScrollPane);

		JTextArea textArea = new JTextArea();
		textAreaScrollPane.setViewportView(textArea);

		windowState.mainOutput = textArea;

		JComboBox<FilterGenerator<ExportableIssue>> filterComboBox = new JComboBox<>();
		filterComboBox.setBounds(396, 43, 166, 20);
		frmIssueBoardExporter.getContentPane().add(filterComboBox);

		windowState.filterComboBox = filterComboBox;

	}
}
