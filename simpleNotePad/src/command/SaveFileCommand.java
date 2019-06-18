package command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import component.JTextPaneWithHistory;

public class SaveFileCommand extends JMenuItem implements Command{

	public SaveFileCommand(String text) {
		super(text);
	}
	
	@Override
	public void execute(JTextPaneWithHistory display) {
        File fileToWrite = null;
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
            fileToWrite = fileChooser.getSelectedFile();
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileToWrite));
            out.println(display.getText());
            JOptionPane.showMessageDialog(null, "File is saved successfully...");
            out.close();
        } catch (IOException ex) { }
	}
}
