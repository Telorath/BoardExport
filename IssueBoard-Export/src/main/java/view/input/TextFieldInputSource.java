package view.input;

import javax.swing.JTextField;

public class TextFieldInputSource implements InputSource<String> {

	private JTextField jTextField;
	
	private boolean clearOnInput;
	
	public TextFieldInputSource(JTextField jTextField, boolean clearOnInput)
	{
		this.jTextField = jTextField;
		this.clearOnInput = clearOnInput;
	}
	
	@Override
	public String getInput() {
		String output = jTextField.getText();
		if (clearOnInput)
		{
			jTextField.setText("");
		}
		return output;
	}

}
