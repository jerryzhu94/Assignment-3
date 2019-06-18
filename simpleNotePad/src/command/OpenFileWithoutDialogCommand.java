package command;

import java.io.File;

import javax.swing.JFileChooser;


public class OpenFileWithoutDialogCommand extends OpenFileCommand implements Command{

	public OpenFileWithoutDialogCommand(String text) {
		super(text);
		this.text = text;
	}
	
	@Override
	protected File getFile() {

        JFileChooser fileChooser = new JFileChooser();
        String filePath = fileChooser.getCurrentDirectory() + "\\" + text;
		File fileToOpen = new File(filePath);
        return fileToOpen;
	}
	
	private String text;
}
