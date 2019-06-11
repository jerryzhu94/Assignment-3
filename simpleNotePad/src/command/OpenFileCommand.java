package command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import component.JTextPaneWithHistory;

public abstract class OpenFileCommand extends JMenuItem implements Command{

	public OpenFileCommand(String text) {
		super(text);
	}
	
	@Override
	public void execute(JTextPaneWithHistory display) {

        try {
        	File fileToOpen = getFile();
        	
            //Read file and append to StringBuilder
        	StringBuilder contentBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(fileToOpen));
            String line;
            while ((line = reader.readLine()) != null)
            	contentBuilder.append(line).append("\n");
            
            //Write StringBuilder content to display
            display.setText(contentBuilder.toString());
            
            JOptionPane.showMessageDialog(null, "File is opened successfully...");
            
            //Store name of opened file to display to maintain a history of recent files opened
            display.addRecentFile(fileToOpen.getName());
    		reader.close();
        } catch (IOException ex) { }
	}
	
	protected abstract File getFile();
}
