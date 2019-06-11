/* RecentFileList is an ArrayList that may contain up to five file names
 */

package data;

import java.util.ArrayList;

public class RecentFileList {
	
	public RecentFileList() {
		fileNames = new ArrayList<String>();
	}
	
	public void add(String fileName) {
		if(fileNames.contains(fileName))
			fileNames.remove(fileName);
		if(fileNames.size() >= 5)
			fileNames.remove(0);
		fileNames.add(fileName);
	}
	
	public int size() {
		return fileNames.size();
	}
	
	public ArrayList<String> getFiles(){
		return fileNames;
	}
	
	public String get(int index) {
		return fileNames.get(index);
	}
	
	private ArrayList<String> fileNames;

}
