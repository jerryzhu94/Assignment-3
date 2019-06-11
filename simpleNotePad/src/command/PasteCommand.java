package command;

import javax.swing.JMenuItem;
import javax.swing.text.Position;
import javax.swing.text.StyledDocument;

import component.JTextPaneWithHistory;

public class PasteCommand extends JMenuItem implements Command{

	public PasteCommand(String text) {
		super(text);
	}
	
	@Override
	public void execute(JTextPaneWithHistory display) {
        StyledDocument document = display.getStyledDocument();
        Position position = document.getEndPosition();
        display.paste();
	}
}
