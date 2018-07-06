package view.input;

import javax.swing.JComboBox;

public class ComboBoxInputSource<T> implements InputSource<T> {
	JComboBox<T> comboBox;

	public ComboBoxInputSource(JComboBox<T> comboBox) {
		this.comboBox = comboBox;
	}

	@Override
	public T getInput() {
		return (T) comboBox.getSelectedItem();
	}

}
