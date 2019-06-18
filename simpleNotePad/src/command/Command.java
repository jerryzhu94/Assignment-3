/* Command defines an interface used to attach and execute GUI component behavior.
 * The design is based off the GoF command pattern. The purpose of this design is to 
 * encapsulate GUI behaviors as an object.
 */

package command;

import component.JTextPaneWithHistory;

public interface Command {
	public void execute(JTextPaneWithHistory display);
}
