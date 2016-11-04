#include <iostream>
#include "calculator.h"

using namespace std;

int const stringSize = 256;

int main()
{
	char string[stringSize] = {'\0'};

	cout << "Enter postfix: ";
	cin.getline(string, stringSize);

	cout << "Result: " << calculator(string) << endl;
	return 0;
}