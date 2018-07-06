package view.io;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.filtering.filters.Filter;
import model.issues.exportable.ExportableIssue;

public class JListIO<T> implements IOListTarget<T> {

	JList<T> jList;

	public JListIO(JList<T> jList) {
		this.jList = jList;
	}

	private DefaultListModel<T> getModel() {
		return (DefaultListModel<T>) jList.getModel();
	}

	@Override
	public T getInput() {
		if (jList.getSelectedIndex() < 0) {
			return null;
		}
		return jList.getSelectedValue();
	}

	@Override
	public List<T> getInputList() {
		return jList.getSelectedValuesList();
	}

	@Override
	public void remove(T item) {
		getModel().removeElement(item);
	}

	@Override
	public void clear() {
		getModel().clear();
	}

	@Override
	public void write(T output) {
		getModel().addElement(output);
	}

	@Override
	public List<T> getAll() {

		List<T> outList = new ArrayList<>();

		for (int i = 0; i < getModel().getSize(); i++) {
			outList.add(getModel().getElementAt(i));

		}

		return outList;
	}

}
