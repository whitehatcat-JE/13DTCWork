// Section B - Task 4 - Jayden Everest
// Includes
#include <iostream>
#include <string>
#include <ctime>
#include <stdlib.h>
// Using declarations
using std::cout;
using std::cin;
using std::endl;

using std::string;

// Draws a line to the terminal
void drawLine() {
    cout << "-----" << endl;
}

// Draws hangman ascii art to terminal
void drawHangman() {
    cout << "   ___" << endl;
    cout << "  |   |" << endl;
    cout << "  |   O" << endl;
    cout << "  |  \\|/" << endl;
    cout << "  |   |" << endl;
    cout << "  |  / \\" << endl;
    cout << "  |" << endl;
    cout << "  |" << endl;
    drawLine(); // Adds line to bottom of art
}

// Draws walkman ascii art to terminal
void drawWalkman() {
    cout << "     " << endl;
    cout << "     O" << endl;
    cout << "    \\|/" << endl;
    cout << "     |" << endl;
    cout << "    / \\" << endl;
    cout << "  " << endl;
    cout << "  " << endl;
}

// Draws invertman ascii art to terminal
void drawInvertMan() {
    cout << "   ___" << endl;
    cout << "  |   |" << endl;
    cout << "  |  /|\\" << endl;
    cout << "  |   |" << endl;
    cout << "  |  /|\\" << endl;
    cout << "  |   O" << endl;
    cout << "  |" << endl;
    cout << "  |" << endl;
    drawLine(); // Adds line to bottom of art
}

// Returns a random word from its array
string getRandomWord() {
    string words[10] = {
        "apple",
        "weka",
        "auckland",
        "team",
        "airplane",
        "bottle",
        "computer",
        "onomatopoeia",
        "car",
        "accommodate"
    };
    return words[rand() % 10];
}

// Returns word with given position char replaced with '_'
string hideLetter(string word, int position) {
    word[position] = '_';
    return word;
}

// Gameplay loop for a round of hangman
bool play(int guessAmt) { // Gets amount of guesses for game
    // Variable declarations & initializations
    string chosenWord = getRandomWord();
    int selectedPos = rand() % chosenWord.length();
    char selectedChar = chosenWord[selectedPos];
    // Draws starter ascii art
    drawHangman();
    // Loops question until either user guesses correct, or guessAmt reached
    for (int guessNum = 0; guessNum < guessAmt; guessNum++) {
        char guessedChar;
        if (guessNum != 0) cout << "Sorry, try again";
        // Gets user guess
        cout << "\nGuess the missing letter in " << hideLetter(chosenWord, selectedPos) << " : ";
        cin >> guessedChar;
        // Stops loop if guess correct
        if (guessedChar == selectedChar) return true;
    }
    return false;
}

// Main function
int main() {
    // Sets random seed
    srand(time(NULL));
    // Runs game & displays varying end message based on win state
    if (play(3)) {
        // Win message
        cout << "\n  Your guess is correct\n";
        drawWalkman();
    } else {
        // Lose message
        cout << "\n  Your guess is wrong\n";
        drawInvertMan();
    }
}