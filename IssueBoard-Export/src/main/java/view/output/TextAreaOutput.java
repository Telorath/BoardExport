package view.output;

import javax.swing.JTextArea;

public class TextAreaOutput implements OutputTarget<String> {

	JTextArea jTextArea;

	public TextAreaOutput(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}

	@Override
	public void clear() {
		jTextArea.setText("");
	}

	@Override
	public void write(String newln) {
		jTextArea.setText(jTextArea.getText() + newln + "\n");
	}

}
