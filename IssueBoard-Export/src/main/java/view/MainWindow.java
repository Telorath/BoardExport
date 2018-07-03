package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MainExportController;
import service.ServiceFactoryInitializer;
import service.factories.ServiceFactory;
import view.events.ExportAction;
import view.output.TextAreaOutput;

public class MainWindow {

	private ServiceFactory serviceFactory;

	private JFrame frmIssueBoardExporter;
	private JTextField textField;

	private MainExportController exportController;

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

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		serviceFactory = new ServiceFactoryInitializer().getServiceFactory();

		frmIssueBoardExporter = new JFrame();
		frmIssueBoardExporter.setTitle("Issue Board Exporter");
		frmIssueBoardExporter.setBounds(100, 100, 588, 368);
		frmIssueBoardExporter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIssueBoardExporter.getContentPane().setLayout(null);

		JButton btnexportButton = new JButton("Perform Export");
		btnexportButton.setBounds(10, 11, 110, 23);
		frmIssueBoardExporter.getContentPane().add(btnexportButton);
		btnexportButton.addActionListener(new ExportAction(serviceFactory.getMainExportController()));

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 193, 552, 104);
		frmIssueBoardExporter.getContentPane().add(textArea);

		serviceFactory.getMainOutputService().setOutputTarget(new TextAreaOutput(textArea));

		JMenuBar menuBar = new JMenuBar();
		frmIssueBoardExporter.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Settings");
		menuBar.add(mnNewMenu);

		JMenuItem mntmCredentials = new JMenuItem("Credentials");
		mnNewMenu.add(mntmCredentials);

		textField = new JTextField();
		textField.setBounds(130, 12, 294, 20);
		frmIssueBoardExporter.getContentPane().add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 277, 78);
		frmIssueBoardExporter.getContentPane().add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);

		JButton addFilterButton = new JButton("Add Filter");
		addFilterButton.setBounds(297, 43, 89, 23);
		frmIssueBoardExporter.getContentPane().add(addFilterButton);

		JButton removeFilterButton = new JButton("Remove Selected");
		removeFilterButton.setBounds(297, 100, 89, 23);
		frmIssueBoardExporter.getContentPane().add(removeFilterButton);

	}
}
