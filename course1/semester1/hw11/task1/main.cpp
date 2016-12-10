#include <iostream>
#include "finiteStateMachine.h"

using namespace std;

int const stringSize = 256;

int main()
{
	Machine *machine = loadMachine("transitionTable.txt");

	cout << "Enter testing string: ";
	char string[stringSize] = {'\0'};
	cin >> string;

	if (testString(machine, string))
		cout << "Ok" << endl;
	else
		cout << "No" << endl;

	deleteMachine(machine);
	return 0;
}