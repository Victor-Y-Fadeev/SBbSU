#include "directory.h"
#include "peopleList.h"
#include <fstream>
#include <string.h>

using namespace std;

int const stringSize = 256;

void saveBase(PeopleList *base, char path[])
{
	fstream file;
	file.open(path, ios::out);

	int s = size(base);
	for (int i = 0; i < s; i++)
	{
		char name[stringSize] = {'\0'};
		int phone = 0;

		strcpy(name, getValue(base, i, phone));
		file << name << "	" << phone << endl;
	}

	file.close();
}

void loadBase(PeopleList *base, char path[])
{
	fstream file;
	file.open(path, ios::in);

	if (file.fail())
	{
		file.close();
		return;
	}

	char *name = new char[stringSize];
	int phone = 0;
	file >> name;
	file >> phone;
	while (!file.eof())
	{
		add(base, name, phone);
		name = new char[stringSize];
		file >> name;
		file >> phone;
	}
	delete[] name;

	file.close();
}