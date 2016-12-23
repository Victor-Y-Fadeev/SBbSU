#include "finiteStateMachine.h"
#include <fstream>
#include <string.h>

using namespace std;

int const charSize = 256;
int const stringSize = 256;

struct Machine
{
	int **table;
	int sizeI;
};


int **createTable(int sizeI)
{
	int **table = new int*[sizeI];

	for (int i = 0; i < sizeI; i++)
		table[i] = new int[charSize];

	return table;
}

void filling(Machine *machine, fstream &file)
{
	for (int i = 0; i < machine->sizeI; i++)
	{
		bool fill = false;
		file >> fill;
		for (int j = 0; j < charSize; j++)
		{
			if (fill)
				machine->table[i][j] = machine->sizeI;
			else
				machine->table[i][j] = -1;
		}
	}
}

void loadSymbols(Machine *machine, fstream &file)
{
	int symbols = 0;
	file >> symbols;
	for (int k = 0; k < symbols; k++)
	{
		char symbol[stringSize] = {'\0'};
		file >> symbol;

		if (strcmp(symbol, "space") == 0)
			symbol[0] = ' ';
		
		for (int i = 0; i < machine->sizeI; i++)
		{
			int top = 0;
			file >> top;
			if (symbol[1] == '-')
			{
				for (int j = (unsigned char)symbol[0]; j < (unsigned char)symbol[2]; j++)
					machine->table[i][j] = top;
			}
			else
				machine->table[i][(unsigned char)symbol[0]] = top;
		}
	}
}

Machine *loadMachine(char *path)
{
	Machine *answer = new Machine;
	fstream file;
	file.open(path, ios::in);

	file >> answer->sizeI;

	answer->table = createTable(answer->sizeI);

	filling(answer, file);
	loadSymbols(answer, file);

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