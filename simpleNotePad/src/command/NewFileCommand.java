package command;

import javax.swing.JMenuItem;

import component.JTextPaneWithHistory;

public class NewFileCommand extends JMenuItem implements Command{

	public NewFileCommand(String text) {
		super(text);
	}
	
	@Override
	public void execute(JTextPaneWithHistory display) {
		display.setText("");
	}
}
