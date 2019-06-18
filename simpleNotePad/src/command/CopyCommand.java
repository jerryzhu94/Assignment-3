package command;

import javax.swing.JMenuItem;

import component.JTextPaneWithHistory;

public class CopyCommand extends JMenuItem implements Command{

	public CopyCommand(String text) {
		super(text);
	}
	
	@Override
	public void execute(JTextPaneWithHistory display) {
		display.copy();
	}
}
