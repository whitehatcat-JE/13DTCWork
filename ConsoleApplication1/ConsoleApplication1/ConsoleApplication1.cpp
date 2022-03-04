// Text RPG
#include <iostream>
#include <array>

using namespace std;

bool fight(int playerStartingHealth, int level) {
	string names[] = {
		"Slime",
		"Spider",
		"Fox",
		"Tiger",
		"Wolf",
		"Snake",
		"Robot",
		"T-Rex",
		"Attack Helicopter",
		"Slime Prophet",
		"Slime God"
	};
	// Attack damage, health, dodgeChance, enragedChance, isEnraged, isPoisoned
	int enemyData[] = { 1 * ((rand() % level) + level / 2 + 1), 20 * ((rand() % level) + level / 2 + 1), 1 * ((rand() % level) + level / 2 + 1), 25 + ((rand() % level) + level / 2), 0, 0 };
	int enemyLevel = (enemyData[0] - 1) + (enemyData[1] / 20);
	if (enemyLevel > 10) {
		enemyLevel = 11;
		enemyData[0] *= 3;
		enemyData[1] *= 2;
		enemyData[2] *= 5;
		enemyData[3] *= 2;
	}
	if (enemyData[2] > 90) {
		enemyData[2] = 90;
	}
	else if (enemyLevel < 1) {
		enemyLevel = 1;
	}

	cout << "A wild " << names[enemyLevel - 1] << " (Lvl: " << enemyLevel << ") approaches!\n" << endl;

	int playerHealth = playerStartingHealth;

	while (enemyData[1] > 0 && playerHealth > 0) {
		int action;
		cout << "Health: " << playerHealth << " | " << names[enemyLevel - 1] << " Health: " << enemyData[1] << endl;
		cout << "   1: Glare\n   2: Spit\n   3: Heal\n: ";
		cin >> action;
		switch (action) {
		case 1:
			if (rand() % 100 <= enemyData[2]) {
				cout << names[enemyLevel - 1] << " dodges" << endl;
			}
			else {
				int damageAmt = 3;
				enemyData[1] -= damageAmt;
				cout << names[enemyLevel - 1] << " takes " << damageAmt << " damage" << endl;
				if (rand() % 100 <= level) {
					damageAmt *= (rand() % (level + 1));
					enemyData[1] -= damageAmt;
					cout << "CRITICAL HIT (x" << 3 / damageAmt << ")" << endl;
				}
			}
			break;
		case 2:
			enemyData[5] = 1;
			cout << names[enemyLevel - 1] << " is now poisoned" << endl;
			break;
		case 3:
			int healthBoostAmt = 3 * level;
			playerHealth += healthBoostAmt;
			cout << "+" << healthBoostAmt << " health" << endl;
			if (rand() % 100 <= enemyData[3]) {
				cout << names[enemyLevel - 1] << " is now enraged" << endl;
				enemyData[4] = 3;
			}
			break;
		}
		do {
			playerHealth -= enemyData[0];
			if (enemyLevel == 11) {
				cout << names[enemyLevel - 1] << " uses annililation, doing " << enemyData[0] << " damage" << endl;
				if (rand() % 100 <= level * 2) {
					playerHealth -= enemyData[0];
					cout << "CRITICAL HIT (x2 damage)" << endl;
				}
				else if (rand() % 100 <= level) {
					playerHealth -= enemyData[0] * 2;
					cout << "SUPREME CRITICAL HIT (x3 damage)" << endl;
				}
			}
			else {
				cout << names[enemyLevel - 1] << " does " << enemyData[0] << " damage" << endl;
				if (rand() % 100 <= level) {
					playerHealth -= enemyData[0];
					cout << "CRITICAL HIT (x2 damage)" << endl;
				}
			}
			if (enemyData[5] == 1) {
				enemyData[1] -= 1 * level;
				cout << names[enemyLevel - 1] << " take " << 1 * level << " poison damage" << endl;
				if (rand() % 100 <= 25) {
					cout << names[enemyLevel - 1] << " recovers from poison" << endl;
					enemyData[5] = 0;

				}
			}
			if (enemyData[4] > 0) {
				enemyData[4] -= 1;
			}
		} while (enemyData[4] > 0);
	}
	if (enemyData[1] > playerHealth) {
		cout << "You died!" << endl;
		return false;
	}
	else if (playerHealth > enemyData[1]) {
		cout << "You won!" << endl;
		return true;
	}
	else {
		cout << "Both you and the " << names[enemyLevel - 1] << " have died!" << endl;
		return false;
	}
}

int main() {
	srand(time(NULL));
	bool playAgain = true;
	int level = 1;
	cout << "Welcome player...\n\n";
	while (playAgain) {
		if (fight(10 * level, level)) {
			level++;
			cout << "Player has levelled up! (Lvl:" << level << ")" << endl;
			cout << "+10 Maximum Life" << endl;
		}
		playAgain = false;
		string continueResponse;
		do {
			cout << "\nContinue? (y/n): ";
			cin >> continueResponse;
		} while (!(continueResponse == "y" || continueResponse == "n"));
		if (continueResponse == "y") {
			playAgain = true;
		}
	}
	cout << "Safe travels, adventurer!" << endl;
}