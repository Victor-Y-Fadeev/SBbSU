#include <iostream>
#include "finiteStateMachine.h"

using namespace std;

int const stringSize = 1024;

int main()
{
	Machine *machine = loadMachine("numberTable.txt");

	cout << "Enter testing string: ";
	char *string = new char[stringSize];
	string[0] = '\0';
	cin >> string;

	char *temp = string;
	if (testString(machine, temp))
		cout << "Ok" << endl;
	else
		cout << "No" << endl;
	
	delete[] string;
	deleteMachine(machine);
	return 0;
}