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

void drawLine() {
    cout << "-----" << endl;
}

void drawHangman() {
    cout << "   ___" << endl;
    cout << "  |   |" << endl;
    cout << "  |   O" << endl;
    cout << "  |  \\|/" << endl;
    cout << "  |   |" << endl;
    cout << "  |  / \\" << endl;
    cout << "  |" << endl;
    cout << "  |" << endl;
    drawLine();
}

void drawWalkman() {
    cout << "     " << endl;
    cout << "     O" << endl;
    cout << "    \\|/" << endl;
    cout << "     |" << endl;
    cout << "    / \\" << endl;
    cout << "  " << endl;
    cout << "  " << endl;
}

void drawInvertMan() {
    cout << "   ___" << endl;
    cout << "  |   |" << endl;
    cout << "  |  /|\\" << endl;
    cout << "  |   |" << endl;
    cout << "  |  /|\\" << endl;
    cout << "  |   O" << endl;
    cout << "  |" << endl;
    cout << "  |" << endl;
    drawLine();
}

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

void currentResults()

void play() {
    string wordl
}

int main()
{
    srand(time(NULL));
    play();
}