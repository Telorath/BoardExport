package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class ChangeTextAction implements ActionListener {

	private JTextArea textArea;
	
	private String textToChangeTo;

	
	
	public ChangeTextAction(JTextArea textArea)
	{
		this.textArea = textArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.setText("You clicked a button!");
	}

	public String getTextToChangeTo()
	{
		return textToChangeTo;
	}
	
	public void setTextToChangeTo(String newText)
	{
		textToChangeTo = newText;
	}
	
}
