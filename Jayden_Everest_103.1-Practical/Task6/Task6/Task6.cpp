// Section B - Task 6 - Jayden Everest
// Includes
#include <iostream>
#include <stdlib.h>
// Using Declarations
using std::cout;
using std::cin;
using std::endl;

const int DAYS = 7;

struct DailyExpense {
    int day;
    int month;
    int year;
    float transportCost;
    float mealCost;
    float entertainmentCost;
    float otherCost;
    DailyExpense(int dayDate, int monthDate, int yearDate, float transport, float meal, float entertain, float other) {
        day = dayDate;
        month = monthDate;
        year = yearDate;
        transportCost = transport;
        mealCost = meal;
        entertainmentCost = entertain;
        otherCost = other;
    }
};

void incrementDate(int* day, int* month, int* year) {
    *day += 1;
    switch (*month) {
    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        if (*day == 31) {
            *day = 1;
            *month += 1;
            if (*month == 13) {
                *month = 1;
                *year += 1;
            }
        }
        break;
    case 2:
        if (*year % 4 == 0 && (*year % 100 != 0 || *year % 400 == 0)) {
            if (*day == 29) {
                *day = 1;
                *month = 3;
            }
        }
        else {
            if (*day == 28) {
                *day = 1;
                *month = 3;
            }
        }
        break;
    case 4: case 6: case 9: case 11:
        if (*day == 30) {
            *day = 1;
            *month += 1;
        }
        break;
    }
}

void updateExpenses(DailyExpense* recordedExpenses) {
    int dayDate, monthDate, yearDate;
    cout << "\n Enter date of first expense:\n\tDay: ";
    cin >> dayDate;
    cout << "\tMonth: ";
    cin >> monthDate;
    cout << "\tYear: ";
    cin >> yearDate;
    cout << "---------------\n";
    for (int day = 0; day < DAYS; day++) {
        (*(recordedExpenses + day)).day = dayDate;
        (*(recordedExpenses + day)).month = monthDate;
        (*(recordedExpenses + day)).year = yearDate;
        cout << "\nEnter transport cost for day " << day + 1 << ": ";
        cin >> (*(recordedExpenses + day)).transportCost;
        cout << "Enter meal cost for day " << day + 1 << ": ";
        cin >> (*(recordedExpenses + day)).mealCost;
        cout << "Enter entertainment cost for day " << day + 1 << ": ";
        cin >> (*(recordedExpenses + day)).entertainmentCost;
        cout << "Enter other costs for day " << day + 1 << ": ";
        cin >> (*(recordedExpenses + day)).otherCost;
        incrementDate(&dayDate, &monthDate, &yearDate);
    }
}

void displayDaily(DailyExpense* recordedExpenses) {

}

void displayWeekly(DailyExpense* recordedExpenses) {

}

void menu(DailyExpense* recordedExpenses) {

}

int main()
{
    DailyExpense recordedExpenses[DAYS] = {
        DailyExpense(1, 1, 2022, 15.9, 45, 0, 0),
        DailyExpense(2, 1, 2022, 16, 60.5, 0, 2.5),
        DailyExpense(3, 1, 2022, 14.54, 43.2, 12.5, 0),
        DailyExpense(4, 1, 2022, 19.32, 76, 0, 0),
        DailyExpense(5, 1, 2022, 12.1, 32.2, 0, 4.75),
        DailyExpense(6, 1, 2022, 0, 47.8, 25, 0),
        DailyExpense(7, 1, 2022, 0, 102.5, 74.5, 3.0)
    };

    menu(recordedExpenses);

}