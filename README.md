# TicTacToe Game 
* Welcome to the TicTacToe Game, this is a classic TicTacToe game developed using Java Language and it’s GUI using JavaFx library.
* It enables you to play in various modes, single and multiplayer both online and offline. Separating the Client from the Server side allows us to have a nicer separation of concerns.

## How to Play
1)	Main Menu
You should select your options from main menu either to play a new game or to load games (review old, played games). You get to exit the game here.
2)	Mode Selection 
You should select one of three modes: 
•	Single Mode: in which you play against the computer (more specifically AI code), you should play the first move and then the computer responds.
•	Multiplayer (offline): in which you and your opponent can play against each other using the same machine.
•	Multiplayer (online): in which you and your opponent can play against each other using the different machine using network.
Still at this phase you can go back to main menu where you can reselect your options.
3)	Options Within the Game:
After the game finishes you can choose to play a new game in the same mode from “Play Again” button or you can go back to mode selection menu and choose to play another game with a different mode using “Back” button. You can also view the scores of both players (X, O).
4)	Load Game:
If you selected load games from the main menu this will take you to a new screen. In which you can select which game (from your past games) you want to display, with unlimited history from the drop-down menu on the upper right corner. Also, here you can choose to go back to main menu from the “Back” button.






## Project Main parts:
*	Server
This is where the business is done. Briefly, Once it receives request from a player it opens a connection (this can be done for many players all at once), and when the game finishes it will update the database with new data or in case of “Load Games” display the game based on a value saved in DB for X and O.
*	Database
Database is MySQL, it has only one table. After the game finishes the server inserts game data into Database in the form of a string that caries the sequence of the game. When the server retrieves the game from the Database this string is split and displayed on the screen. 


###	Issues
You should first change the password at the (databaseCon.class) that enables you to connect to the database.
You should run the server (XO_Server.class) from the netbeans project as there is no jar file that runs the server.


## Contributors
* Hossam Salaheldeen Abdelazeem Othamn
* Maryem Mohamed Sherif Fouad El Saeid
* Mostafa Mahmoud Fathi Mahmoud Eldalil
* Walaa Abdelmonem Ahmed Mohamed Elbasha 
* Yehia Khalil Ali ElSayed
