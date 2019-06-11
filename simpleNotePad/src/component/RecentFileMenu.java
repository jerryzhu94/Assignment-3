/* RecentFileMenu dynamically updates the list of recent files by retrieving the 
 * recent file history from display.
 */

package component;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import command.OpenFileWithoutDialogCommand;
import data.RecentFileList;


public class RecentFileMenu extends JMenu  {
	
	public RecentFileMenu(String text, JFrame frame, JTextPaneWithHistory display){
		super(text);
		this.frame = frame;
		this.display = display;
		defineBehavior();
	}
	
	//Updates the components in RecentFileMenu whenever menu is selected by user
	private void defineBehavior() {
		this.addMenuListener(new MenuListener() {
		    @Override
		    public void menuSelected(MenuEvent event) {
		    	updateMenuItems();
		    }
	
		    @Override
		    public void menuDeselected(MenuEvent e) {
		    }
	
		    @Override
		    public void menuCanceled(MenuEvent e) {
		    }
		});
	}
	
	//Helper method: Updates the components in RecentFileMenu
	private void updateMenuItems() {
		this.removeAll();
		RecentFileList recentFiles = display.getRecentFiles();
		if(recentFiles != null) {
			for(int i = recentFiles.size() - 1; i >= 0 ; i--) {
				JMenuItem recentFileMenuItem = new OpenFileWithoutDialogCommand(recentFiles.get(i));
				recentFileMenuItem.addActionListener((ActionListener) frame);
				this.add(recentFileMenuItem);
			}
		}
	}
	
	private JFrame frame;
	private JTextPaneWithHistory display;
}
