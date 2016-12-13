#include "finiteStateMachine.h"
#include <fstream>

using namespace std;

struct Machine
{
	int **table;
	int sizeI;
	int sizeJ;
};


int **createTable(int sizeI, int sizeJ)
{
	int **table = new int*[sizeI];

	for (int i = 0; i < sizeI; i++)
		table[i] = new int[sizeJ];

	return table;
}

Machine *loadMachine(char *path)
{
	Machine *answer= new Machine;
	fstream file;
	file.open(path, ios::in);

	file >> answer->sizeI;
	file >> answer->sizeJ;

	answer->table = createTable(answer->sizeI, answer->sizeJ);

	for (int i = 0; i < answer->sizeI; i++)
		for (int j = 0; j < answer->sizeJ; j++)
			file >>	answer->table[i][j];

	file.close();
	return answer;
}


bool testString(Machine *machine, char *&string, int top)
{
	top = machine->table[top][(unsigned char)string[0]];

	if (top == machine->sizeI)
		return true;

	if (top == -1)
		return false;

	string++;
	return testString(machine, string, top);
}

bool testString(Machine *machine, char *&string)
{
	int top = 0;
	char *testingString = string;
	bool answer = testString(machine, testingString, top);

	if (answer)
		string = testingString;

	return answer;
}
	

void deleteTable(int **&table, int sizeI)
{
	for (int i = 0; i < sizeI; i++)
		delete[] table[i];

	delete[] table;
	table = nullptr;
}

void deleteMachine(Machine *&machine)
{
	deleteTable(machine->table, machine->sizeI);
	delete machine;
	machine = nullptr;
}