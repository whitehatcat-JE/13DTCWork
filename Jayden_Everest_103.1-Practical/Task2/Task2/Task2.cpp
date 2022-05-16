// Section A - Task 2 - Jayden Everest
// Includes
#include <iostream>
// Using declarations
using std::cout;
using std::cin;

// Returns the sum of all non-negatives values in an array
float sumArray(float *values, int arrLength) {
    float total = 0.0; // Current total
    for (int val = 0; val < arrLength; val++) {
        total += *values >= 0.0 ? *values : 0.0; // Defaults to 0 if value is less than 0
        values++; // Selects next array value
    }
    return total;
}

int main()
{
    // Variable declarations
    float sumValues[5];
    int sumAmt = 5;
    
    // User instructions
    cout << "Please enter 5 values, of which the Non-Negative values will be summed." << std::endl;
    // Get all values to sum from user
    for (int val = 0; val < sumAmt; val++) {
        cout << "\tEnter value " << val + 1 << ": ";
        cin >> sumValues[val];
    }
    // Get & Output sum
    cout << "\nTotal of values: " << sumArray(sumValues, sumAmt);
}