// Section A - Task 3 - Jayden Everest
// Includes
#include <iostream>
#include <string>
// Using declarations
using std::cout;
using std::cin;
using std::endl;
using std::string;

// Fills a given 3x3 integer matrix with user inputs
void fillMatrix(float matrix[3][3]) {
    for (int row = 0; row < 3; row++) {
        for (int column = 0; column < 3; column++) {
            cout << "Enter value for (" << column << ", " << row << "): ";
            cin >> matrix[row][column];
        }
    }
}

// Add two matrices together, storing the result in the third parameters matrix.
void addMatrices(float matrixA[3][3], float matrixB[3][3], float matrixC[3][3]) {
    for (int row = 0; row < 3; row++) {
        for (int column = 0; column < 3; column++) {
            matrixC[row][column] = matrixA[row][column] + matrixB[row][column];
        }
    }
}

// Multiply a given matrix by 3
void multiplyMatrix(float matrix[3][3]) {
    for (int row = 0; row < 3; row++) {
        for (int column = 0; column < 3; column++) {
            matrix[row][column] *= 3;
        }
    }
}

// Print a given 3x3 matrix to the terminal
void printMatrix(float matrix[3][3], string name) {
    cout << "Matrix " << name << ": ";
    for (int row = 0; row < 3; row++) {
        cout << "\n("; // Changes to new line when current row has been completed
        for (int column = 0; column < 3; column++) {
            cout << matrix[row][column] << (column == 2 ? ")" : ", "); // Changes output based on column position
        }
    }
    cout << endl;
}

int main()
{
    // Matrix declarations
    float matrixA[3][3], matrixB[3][3], matrixC[3][3];
    // Fills matrixA & matrixB with user inputted values
    cout << "Matrix A values: " << endl;
    fillMatrix(matrixA);
    cout << "Matrix B values: " << endl;
    fillMatrix(matrixB);
    // Add matrixA & matrixB together, storing result in matrixC
    addMatrices(matrixA, matrixB, matrixC);
    // Output result
    printMatrix(matrixC, "Result (Added)");
    // Multiply matrixC by 3
    multiplyMatrix(matrixC);
    // Output result
    printMatrix(matrixC, "Result (Multiplied x3)");
}
