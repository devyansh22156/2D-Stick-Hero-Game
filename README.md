# 2D-Stick-Hero-Game
# Read Me
The StickMan Hero Game consists of several classes and interfaces to implement OOPS. The start screen of the game displays:
1.	NEW GAME BUTTON: The user can click on this to start a new game.
2.	RESUME GAME: On clicking on this, the user will be directed to another screen that would call for the user to login. If the user already has data saved, then the game will be resumed from where originally the game was left, else error would appear.
3.	CREDITS BUTTON
Rules:
1.	The player will be holding the mouse button for the stick length to grow.
2.	If the stick is of adequate length, the player will cross the pillars and the game move forwards, else the player is going to fall and the game will display GAME OVER Screen.
3.	For each successful crossing, the player gets 1 point.
4.	If there are cherries in between, the player can again hold the mouse pad to collect the cherries. For each cherry, 3 points are obtained.
5.	If the stick length is exactly half the length between two pillars, the total points obtained is doubled.
Game Logisitics
Packages:
1.	Game: 
a)	Player Class -> Each player has name, age, phone number and a scorelist (which is a list of all the scores of the player).
b)	Main -> Executes the whole game.
2.	Game Mechanics:
a) GameBackEnd Class -> This is the class that has all the game mechanisms and functions running. Methods:
-	increaseStickLength() -> This method increases the length of the stick by 3 units on each second of hold.
-	animateStick() -> This method performs the required animations with the stick.
-	rotateStick() -> This method rotates the stick after the hold is released.
-	addTranslationAndTranslation() -> This method moves the stick figure over the stick that has been rotated and kept on the other side of the pillar.
-	insertStick() -> This method inserts a stick between the two poles.
-	checkCondition() -> This method is responsible for deciding whether the stick length is adequate or not.
-	moveToNextStage() -> A new pillar is generated and the original pillar is switched to next one.
-	generateGap() -> This method invokes a random gap between the two pillars.
-	generateCherry() -> This method randomly generated cherries between pillars.
-	Getters and Setters etc.
b)	Character Class -> This class has various options for the character that can be selected by the player. By default, it is red among us character.
c)	Cherry Class -> This class contains information about the cherry object.
d)	Pillar Class -> This class contains information about the pillar objects that will be formed.
e)	Score Class -> This class has all attributes associated with score such as total points, number of cherries procured etc.
f)	Stick Class -> This class predefines the attributes of the stick.
3.	Model Package:
a) GameButtons Class -> This Class defines all the functions and setup of the buttons of the game. It provides methods to click on buttons, set buttons styles, mouse on release button etc. This is the basic essence of all the functions and UI design made later.
b)	GameRectangle Class -> This class sets the specification of the rectangle (character) moving in the game.
4.	UI:
a)	MenuUI Class -> This provides the basic screen of the Menu UI. The Menu has several pressable buttons that directs the users to various different locations as per demanded. We have made several methods to facilitate the usage of these buttons.
b)	LoginUI Interface and Classes -> An interface has been made along with two classes that implement it so that whenever a user creates a new profile (new game), the user is asked to register. The data of the user is then stored in a global array of users that we have made. Furthermore, if the user decided to resume game, then the user will be asked for the credentials and it will be searched in the database. In case, the player is not found to have an existing record, an error message is displayed and the user is redirected.
c)	GamePlayUI Class -> This class runs all the functionality of the game. It is implemented when NEW GAME BUTTON or RESUME GAME BUTTON is pressed.
d)	CreditsDisplayUI 
e)	PlayerProfileUI
f)	SelectCharacterUI  
In addition to this, we also have made a Resources folder to store all the required images, text fonts etc. that are used in the project.
OOPS used:
1.	Inheritance
2.	Interfaces
3.	Polymorphism
4.	Object Class and its Functions
5.	Multithreading
6.	UML 
7.	Exception Handling
8.	Assertions
9.	Design Patterns
10.	Abstract Classes etc. 
