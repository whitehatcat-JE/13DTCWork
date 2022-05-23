// Section B - Task 6 - Jayden Everest
// Includes
#include <iostream>
#include <stdlib.h>
// Using Declarations
using std::cout;
using std::cin;
using std::endl;

// Constants
const int DAYS = 7;

// Store a given dates expenses
struct DailyExpense {
    // Date Variables
    int day;
    int month;
    int year;
    // Expense Variables
    float transportCost;
    float mealCost;
    float entertainmentCost;
    float otherCost;
    // Constructor
    DailyExpense(int dayDate, int monthDate, int yearDate, float transport, float meal, float entertain, float other) {
        // Initialize date
        day = dayDate;
        month = monthDate;
        year = yearDate;
        // Initialize expenses
        transportCost = transport;
        mealCost = meal;
        entertainmentCost = entertain;
        otherCost = other;
    }
};

// Advances a given date by 1, accounting for differing month lengthsand leap years
void incrementDate(int* day, int* month, int* year) {
    switch (*month) {
    // Jan, Mar, May, Jul, Aug, Oct, Dec
    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        if (*day == 31) { // Advance month
            *day = 1;
            *month += 1;
            // Switch to new year
            if (*month == 13) {
                *month = 1;
                *year += 1;
            }
        }
        else {
            *day += 1;
        }
        break;
    // Feb
    case 2:
        if (*year % 4 == 0 && (*year % 100 != 0 || *year % 400 == 0)) { // Checks if leap year
            if (*day == 29) { // Advance month
                *day = 1;
                *month = 3;
            }
            else {
                *day += 1;
            }
        }
        else {
            if (*day == 28) { // Advance month
                *day = 1;
                *month = 3;
            }
            else {
                *day += 1;
            }
        }
        break;
    // Apr, Jun, Sep, Nov
    case 4: case 6: case 9: case 11:
        if (*day == 30) { // Advance month
            *day = 1;
            *month += 1;
        }
        else {
            *day += 1;
        }
        break;
    }
}

// Updates stored expenses
void updateExpenses(DailyExpense* recordedExpenses) {
    // Date Variable Declarations
    int dayDate, monthDate, yearDate;
    // Gets date of first day (Can then increment for rest of days)
    do {
        cout << "\n Enter valid date of first expense:\n\tDay: ";
        cin >> dayDate;
        cout << "\tMonth: ";
        cin >> monthDate;
        cout << "\tYear: ";
        cin >> yearDate;
    } while (dayDate > 31 || dayDate < 1 || monthDate > 12 || monthDate < 1 || yearDate < 0);
    cout << "---------------\n";
    // Get costs for each day
    for (int day = 0; day < DAYS; day++) {
        // Records date
        (*(recordedExpenses + day)).day = dayDate;
        (*(recordedExpenses + day)).month = monthDate;
        (*(recordedExpenses + day)).year = yearDate;
        // Get all daily expenses
        cout << "\nEnter transport cost for day " << day + 1 << ": ";
        cin >> (*(recordedExpenses + day)).transportCost;
        cout << "Enter meal cost for day " << day + 1 << ": ";
        cin >> (*(recordedExpenses + day)).mealCost;
        cout << "Enter entertainment cost for day " << day + 1 << ": ";
        cin >> (*(recordedExpenses + day)).entertainmentCost;
        cout << "Enter other costs for day " << day + 1 << ": ";
        cin >> (*(recordedExpenses + day)).otherCost;
        // Increment date
        incrementDate(&dayDate, &monthDate, &yearDate);
    }
}

// Displays expenses for every day stored
void displayDaily(DailyExpense* recordedExpenses) {
    cout << "Daily expenses over 7 days:\n";
    // Loops through each day
    for (int day = 0; day < DAYS; day++) {
        // Calculat total expenses for day
        float dailyExpense = 0.0;

        dailyExpense += (*(recordedExpenses + day)).transportCost;
        dailyExpense += (*(recordedExpenses + day)).mealCost;
        dailyExpense += (*(recordedExpenses + day)).entertainmentCost;
        dailyExpense += (*(recordedExpenses + day)).otherCost;

        // Output expenses to terminal
        cout << "\nDay No." << day + 1
            << " - " << (*(recordedExpenses + day)).day
            << "/" << (*(recordedExpenses + day)).month
            << "/" << (*(recordedExpenses + day)).year
            << "\n\tTransport Costs: " << (*(recordedExpenses + day)).transportCost
            << "\n\tMeal Costs: " << (*(recordedExpenses + day)).mealCost
            << "\n\tEntertainment Costs: " << (*(recordedExpenses + day)).entertainmentCost
            << "\n\tOther Costs: " << (*(recordedExpenses + day)).otherCost
            << "\n\tTotal Daily Expenses: $" << dailyExpense
            << endl;
    }
}

// Displays expenses for week
void displayWeekly(DailyExpense* recordedExpenses) {
    cout << "Weekly expenses: \n";
    // Total expense Variable Declarations
    float totalTransport = 0.0, totalMeal = 0.0, totalEntertain = 0.0, totalOther = 0.0, totalExpense;

    // Calculate total category expenses
    for (int day = 0; day < DAYS; day++) {
        totalTransport += (*(recordedExpenses + day)).transportCost;
        totalMeal += (*(recordedExpenses + day)).mealCost;
        totalEntertain += (*(recordedExpenses + day)).entertainmentCost;
        totalOther += (*(recordedExpenses + day)).otherCost;
    }
    // Calculate overall total expenses
    totalExpense = totalTransport + totalMeal + totalEntertain + totalOther;

    // Output totals
    cout << "\tTotal Transport Costs: $" << totalTransport
        << "\n\tTotal Meal Costs: $" << totalMeal
        << "\n\tTotal Entertainment Costs: $" << totalEntertain
        << "\n\tTotal Other Costs: $" << totalOther
        << "\n\n\tTotal Weekly Expenses: $" << totalExpense
        << endl;
}

// Menu interface
void menu(DailyExpense* recordedExpenses) {
    // Gets user to select menu option
    int selected;
    cout << "\nMain Menu\n1. Display Daily Expenses\n2. Display Weekly Expenses\n3. Update Expenses\n4. Quit\n";
    cin >> selected;
    // Executes given options code
    switch (selected) {
    case 1: // Display daily expenses
        displayDaily(recordedExpenses);
        menu(recordedExpenses);
        break;
    case 2: // Display weekly expenses
        displayWeekly(recordedExpenses);
        menu(recordedExpenses);
        break;
    case 3: // Update stored expenses
        updateExpenses(recordedExpenses);
        menu(recordedExpenses);
        break;
    case 4: // Exit
        return;
    default: // Invalid option catch
        cout << "Unknown option, please try again.";
        menu(recordedExpenses);
        break;
    }
}

// Main function
int main()
{
    // Initialize expenses struct array
    DailyExpense recordedExpenses[DAYS] = {
        // Placeholder data
        DailyExpense(1, 1, 2022, 15.9, 45, 0, 0),
        DailyExpense(2, 1, 2022, 16, 60.5, 0, 2.5),
        DailyExpense(3, 1, 2022, 14.54, 43.2, 12.5, 0),
        DailyExpense(4, 1, 2022, 19.32, 76, 0, 0),
        DailyExpense(5, 1, 2022, 12.1, 32.2, 0, 4.75),
        DailyExpense(6, 1, 2022, 0, 47.8, 25, 0),
        DailyExpense(7, 1, 2022, 0, 102.5, 74.5, 3.0)
    };

    // Runs main menu
    menu(recordedExpenses);
}