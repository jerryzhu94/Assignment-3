package command;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import component.JTextPaneWithHistory;

public class ReplaceCommand extends JMenuItem implements Command{

	public ReplaceCommand(String text) {
		super(text);
	}
	
	@Override
	public void execute(JTextPaneWithHistory display) {
		String replacementString = JOptionPane.showInputDialog("Replace or insert with:");
		display.replaceSelection(replacementString);
	}
}
