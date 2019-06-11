/* JTextPaneWithHistory was extended to maintain a history of the recent files that were opened
 * Its methods are used in the RecentFileMenu and OpenFileCommand class
 */

package component;

import javax.swing.JTextPane;

import data.RecentFileList;

public class JTextPaneWithHistory extends JTextPane{

	public JTextPaneWithHistory() {
		super();
		recentFileList = new RecentFileList();
	}
	
	public void addRecentFile(String fileName) {
		recentFileList.add(fileName);
	}
	
	public RecentFileList getRecentFiles() {
		return recentFileList;
	}
	
	private RecentFileList recentFileList;
}
