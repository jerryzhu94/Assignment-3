# Assignment-3
Refactored SimpleNotePad application. Command design pattern was used to dynamically attach behavior to GUI components.


Code smells

1.	Bloater. SimpleNotePad class defines both business logic and GUI in this class, hence resulting in low cohesion.
2.	Object-orientation abusers. Long if/else statements starting from line 70 to 115.
3.	Bloater. actionPerformed method is very long because it contains all the GUI behaviors. As more features get added, this method will become more unmanageable
4.	Duplicate code. Copy pasting starting from line 36 to 58.
5.	Poor naming convention. Abuse of acronyms causes poor readability starting from line 24 to 115
6.	Speculative generality. Unused JMenuItem: Undo feature was never implemented at line 117
7.	Testing purpose code not removed at line 114.

Refactor

•	Member fields were renamed. Use of acronyms were avoidable because code needs to be readable for other developers
•	Member fields were explicitly defined as private for improved readability and moved to the bottom of the class. The public methods were defined near the top of the class because developers are usually more interested in API calls.
•	initializeGUIComponent helper class was made to improve readibility in the SimpleNotePad constructor.
•	addMenusToMenuBar and addMenuItemsToMenu helper classes were added to improve extensibility and readability. This reduces the amount of code duplication.
•	Business logic in the actionPerformed method was partitioned into several separate Command classes. The command design pattern was used to encapsulate GUI behaviors as objects. In the future, there may be buttons that have the same or similar behaviors. For example, on word document there are multiple menu items and buttons for saving a document. Isolating the behaviors from the component allows for code reusability. This pattern also enforces the single responsibility principle: every class should have responsibility over a single component or functionality. This significantly improves the overall cohesion. This pattern also enforces the open/close principle: Open for extensions but closed for modification. To introduce a new GUI behavior, a new command class needs to get created and then attached to the command interface. Any code changes will have minimal impact on other classes. 

