// Section A - Task 1 - Jayden Everest
// Includes
#include <iostream>
// Using declarations
using std::cout;
using std::cin;
using std::endl;

// Player position types
enum class position {
    goalkeeper,
    midfielder,
    striker,
    winger,
    defender
};

// Player assoc. information
struct soccer {
    int number = 0;
    float speed = 0.0;
    position type = position::goalkeeper;
};

// User input for a given player
void getPlayerInfo(soccer* playerStats) {
    // Gets general player info
    cout << "New Player Number: ";
    cin >> (*playerStats).number;
    cout << "Player No." << (*playerStats).number << " Max Speed: ";
    cin >> (*playerStats).speed;

    // Gets & Outputs player position
    char inputtedPosition;

    cout << "Player A Position (g/m/s/w/d): ";
    cin >> inputtedPosition;
    switch (inputtedPosition) { // Converts user input into equivalent enumerator
    case 'g':
        (*playerStats).type = position::goalkeeper;
        cout << "Position stored as Goalkeeper." << endl;
        break;
    case 'm':
        (*playerStats).type = position::midfielder;
        cout << "Position stored as Midfielder." << endl;
        break;
    case 's':
        (*playerStats).type = position::striker;
        cout << "Position stored as Striker." << endl;
        break;
    case 'w':
        (*playerStats).type = position::winger;
        cout << "Position stored as Winger." << endl;
        break;
    case 'd':
        (*playerStats).type = position::defender;
        cout << "Position stored as Defender." << endl;
        break;
    default:
        cout << "Unknown Position! Defaulting to Goalkeeper.";
        break;
    }
}

// Prints a given players information
void printPlayerInfo(soccer playerStats) {
    // Output for general player info
    cout << "Stored information for Player No." << playerStats.number << ":" << endl;
    cout << "Max Speed: " << playerStats.speed << "mph" << endl;
    // Output for player position
    cout << "Position: ";
    switch (playerStats.type) { // Converts enum into equivalent word
    case position::goalkeeper:
        cout << "Goalkeeper";
        break;
    case position::midfielder:
        cout << "Midfielder";
        break;
    case position::striker:
        cout << "Striker";
        break;
    case position::winger:
        cout << "Winger";
        break;
    case position::defender:
        cout << "Defender";
        break;
    }
    cout << endl;
}

int main()
{
    // Defines & Gets data for player A
    soccer playerAStats = soccer();
    getPlayerInfo(&playerAStats);
    // Defines & Gets data for player B
    soccer playerBStats = soccer();
    getPlayerInfo(&playerBStats);

    // Outputs the stored player data
    printPlayerInfo(playerAStats);
    printPlayerInfo(playerBStats);
}