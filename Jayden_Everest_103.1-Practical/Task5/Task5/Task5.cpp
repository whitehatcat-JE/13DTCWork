// Section B - Task 5 - Jayden Everest
// Includes
#include <iostream>
#include <ctime>
// Using declarations
using std::cout;
using std::cin;
using std::endl;

// Draws a square to terminal
void drawSquare() {
    cout << " ----------" << endl;
    cout << "|          |" << endl;
    cout << "|          |" << endl;
    cout << "|          |" << endl;
    cout << "|          |" << endl;
    cout << " ----------" << endl;
}

// Draws a triangle to terminal
void drawTriangle() {
    cout << "    /\\" << endl;
    cout << "   /  \\" << endl;
    cout << "  /    \\" << endl;
    cout << " /      \\" << endl;
    cout << "----------" << endl;
}

// Draws a rectangle with a given height and width to terminal
void drawRectangle(int height, int width) {
    // Top
    cout << " ";
    for (int w = 0; w < width; w++) { cout << "--"; }
    // Left and right
    for (int h = 0; h < height; h++) {
        cout << "\n|";
        // Adds spacing between L & R sides based on rect width
        for (int w = 0; w < width; w++) { cout << "  "; }
        cout << "|";
    }
    // Bottom
    cout << "\n ";
    for (int w = 0; w < width; w++) { cout << "--"; }
}

// Calculates total score
int calculateScore(int rightAnswers) {
    int finalScore = 0;
    // Note: This could be done through finalScore = rightAnswers*10;, however task requested incrementation instead
    for (int answer = 0; answer < rightAnswers; answer++) { finalScore += 10; }
    return finalScore;
}

// Plays 1 round of shape guessing, returing the win state
bool play() {
    int shape = rand() % 3; // Randomly selects shape
    switch (shape) { // Displays selected shape
    case 0:
        drawRectangle(5, 10);
        break;
    case 1:
        drawTriangle();
        break;
    case 2:
        drawSquare();
        break;
    }
    // Gets user guess
    char selected;
    cout << "\nWhich shape is this?\na. Rectangle\nb. Triangle\nc. Square\nd. None of the above\n";
    cin >> selected;
    // Returns true if user is right, else false
    if ((char)(shape + 97) == selected) return true;
    return false;
}

// Main gameplay loop, continues to call itself until exit option is selected
void menu(int correctAnswers) {
    // User selects from menu
    int selected;
    cout << "\nMain Menu\n1. Play\n2. Final Score\n3. Exit\n";
    cin >> selected;
    switch (selected) { // Runs selected option
    case 1: // Play Option
        if (play()) {
            cout << "\nCorrect! +10 Points";
            menu(++correctAnswers);
        } else {
            cout << "\nWrong answer";
            menu(correctAnswers);
        }
        break;
    case 2: // Final score Option
        cout << "\nFinal Score: " << calculateScore(correctAnswers);
        menu(correctAnswers);
    case 3: // Exit Option
        break;
    default: // Input error catch
        cout << "\nUnknown option.";
        menu(correctAnswers);
        break;
    }
}

// Main function
int main() {
    srand(time(NULL)); // Sets random seed
    menu(0); // Runs gameplay loop
}