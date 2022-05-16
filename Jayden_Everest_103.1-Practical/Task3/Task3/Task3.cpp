// Section A - Task 3 - Jayden Everest
// Includes
#include <iostream>
#include <string>
// Using declarations
using std::cout;
using std::cin;
using std::endl;
using std::string;

void fillMatrix(float matrix[3][3]) {
    for (int row = 0; row < 3; row++) {
        for (int column = 0; column < 3; column++) {
            cout << "Enter value for (" << column << ", " << row << "): ";
            cin >> matrix[row][column];
        }
    }
}

void printMatrix(float matrix[3][3], string name) {
    cout << "Matrix " << name << ": ";
    for (int row = 0; row < 3; row++) {
        cout << "\n(";
        for (int column = 0; column < 3; column++) {
            cout << matrix[row][column] << (column == 2 ? ")" : ", ");
        }
    }
    cout << endl;
}

int main()
{
    float matrixA[3][3], matrixB[3][3], matrixC[3][3];
    fillMatrix(matrixA);
    fillMatrix(matrixB);
    printMatrix(matrixA, "A");
}
