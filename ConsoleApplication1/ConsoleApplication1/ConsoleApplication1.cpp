// Number guessing game
#include <iostream>

using namespace std;

// Global variables
int a = 0, b = 0, c = 0, addVal = 0, multVal = 0, difficulty = 2;

// Sets the games individual variables
void setValues() {
	// Assigns the three guessable values
	a = (rand() % difficulty) + 1;
	b = (rand() % difficulty) + 1;
	c = (rand() % difficulty) + 1;
	// Calculates the hint values
	addVal = a + b + c;
	multVal = a * b * c;
}

// Runs a single instance of the game
void runGame() {
	// Re-selects game variables
	setValues();

	// Game information outputs
	cout << "Difficulty level: " << difficulty << endl;
	cout << "Hint: " << a << " " << b << " " << c << endl;
	cout << "Numbers adds to " << addVal << " and multiplies to " << multVal << endl;

	// Guess loop variables
	int guessA = 0, guessB = 0, guessC = 0;
	bool guessedCorrectly = false;
	// Loops guesses until the player gets it right
	while (!guessedCorrectly)
	{	
		// Gets player guesses
		cout << "Value A: ";
		cin >> guessA;
		cout << "Value B: ";
		cin >> guessB;
		cout << "Value C: ";
		cin >> guessC;
		// Confirms if the player is correct
		if ((guessA * guessB * guessC != multVal) || (guessA + guessB + guessC != addVal)) {
			cout << "Incorrect!" << endl;
		} else {
			guessedCorrectly = true;
		}
	}
}

// Manages the interface over multiple games
int main() {
	// Sets random seed
	srand(time(NULL));

	// Continue response variable
	string continueResponse = "n";
	
	// Repeats the game until the player quits
	do {
		// Runs the game instance
		runGame();
		
		// Quit option
		cout << "Congratulations! You've won!\nPlay again? (y/n) ";
		cin >> continueResponse;
		difficulty++;
	} while (continueResponse != "n");

	// End message
	cout << "Thanks for playing!";
	return 0;
}