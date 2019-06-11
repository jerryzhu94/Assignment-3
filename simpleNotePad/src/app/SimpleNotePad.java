package app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import command.Command;
import command.CopyCommand;
import command.NewFileCommand;
import command.OpenFileCommand;
import command.OpenFileWithDialogCommand;
import command.OpenFileWithoutDialogCommand;
import command.PasteCommand;
import command.PrintFileCommand;
import command.ReplaceCommand;
import command.SaveFileCommand;
import component.JTextPaneWithHistory;
import component.RecentFileMenu;
import data.RecentFileList;

 class SimpleNotePad extends JFrame implements ActionListener{

	//Constructor
    public SimpleNotePad() {
    	//Initialize GUI components
    	initializeGUIComponents();
    	
    	setTitle("A Simple Notepad Tool");
    	
    	//Initialize arrays and group menus and menu items
    	ArrayList<JMenu> menus = new ArrayList<JMenu>(Arrays.asList(fileMenu, editMenu));
    	ArrayList<JMenuItem> fileMenuItems = new ArrayList<JMenuItem>(Arrays.asList(newFileMenuItem, saveFileMenuItem, printFileMenuItem, openFileMenuItem, recentFileMenu));
    	ArrayList<JMenuItem> editMenuItems = new ArrayList<JMenuItem>(Arrays.asList(copyMenuItem, pasteMenuItem, replaceMenuItem));
    	
    	//Add menus to menu bar
    	addMenusToMenuBar(menuBar, menus);
    	
    	//Add menu items to menus
    	addMenuItemsToMenu(fileMenu, fileMenuItems);
    	addMenuItemsToMenu(editMenu, editMenuItems);
    	
        //Add to display and set Jframe configurations
        add(new JScrollPane(display));
        setPreferredSize(new Dimension(600,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }   
    
    //Define GUI behavior
	@Override
	public void actionPerformed(ActionEvent event) { 
		try {
			Command command = (Command)event.getSource();
			command.execute(display);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
    
    //Helper method: Initialize GUI components
    private void initializeGUIComponents() {
        //Existing features
    	menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        display = new JTextPaneWithHistory();
        newFileMenuItem = new NewFileCommand("New File");
        saveFileMenuItem = new SaveFileCommand("Save File");
        printFileMenuItem = new PrintFileCommand("Print File");
        copyMenuItem = new CopyCommand("Copy");
        pasteMenuItem = new PasteCommand("Paste");
        
        //New features added
        openFileMenuItem = new OpenFileWithDialogCommand("Open File");
        recentFileMenu = new RecentFileMenu("Recent File", this, display);
        replaceMenuItem = new ReplaceCommand("Replace");
    }
    
    //Helper method: Adds array of JMenu to JMenuBar
    private void addMenusToMenuBar(JMenuBar menuBar, ArrayList<JMenu> menus) {
    	for(JMenu menu : menus)
    		menuBar.add(menu);
    	setJMenuBar(menuBar);
    }
    
    //Helper method: Adds array of JMenuItems to JMenu
    private void addMenuItemsToMenu(JMenu menu, ArrayList<JMenuItem> menuItems) {
    	for(JMenuItem menuItem : menuItems){
    		menu.add(menuItem);
    		menuItem.addActionListener(this);
    		menu.addSeparator();
    	}
    }
    
    //Private member fields
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, recentFileMenu;
    private JTextPaneWithHistory display;
    private JMenuItem newFileMenuItem, saveFileMenuItem, printFileMenuItem, copyMenuItem, pasteMenuItem, openFileMenuItem, replaceMenuItem;

}
