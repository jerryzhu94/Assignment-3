package command;

import java.io.File;

import javax.swing.JFileChooser;

public class OpenFileWithDialogCommand extends OpenFileCommand implements Command{

	public OpenFileWithDialogCommand(String text) {
		super(text);
	}

	@Override
	protected File getFile() {
		File fileToOpen = null;
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        	fileToOpen = fileChooser.getSelectedFile();
        
        return fileToOpen;
	}
}
