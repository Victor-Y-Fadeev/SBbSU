#include <iostream>
#include "peopleList.h"
#include "directory.h"

using namespace std;

int const stringSize = 256;

enum Dialog
{
	programExit = '0',
	addRecord,
	findPhone,
	findName,
	saveData
};

void addToBase(PeopleList *base)
{
	cout << "Enter name and phone: ";

	char *name = new char[stringSize];
	cin >> name;
	int phone = 0;
	cin >> phone;
	add(base, name, phone);
	cout << endl;
}

void phone(PeopleList *base)
{
	cout << "Enter name: ";

	char name[stringSize] = {'\0'};
	cin >> name;
	int phone = findPhoneByName(base, name);

	if (phone >= 0)
		cout << "Phone: " << phone << endl;
	else
		cout << "Not found!" << endl;

	cout << endl;
}

void name(PeopleList *base)
{
	cout << "Enter phone: ";

	int phone = 0;
	cin >> phone;
	char *name = findNameByPhone(base, phone);

	if (name[0] != '\0')
		cout << "Name: " << name << endl;
	else
		cout << "Not found!" << endl;

	cout << endl;
}

void screen()
{
	cout << (char)programExit << " - exit;" << endl;
	cout << (char)addRecord << " - add record (name and phone);" << endl;
	cout << (char)findPhone << " - find phone;" << endl;
	cout << (char)findName << " - find name;" << endl;
	cout << (char)saveData << " - save data." << endl << endl;
}

void menu(PeopleList *base)
{
	char ch = '\0';

	screen();
	while (ch != programExit)
	{
		cin >> ch;
		switch (ch)
		{
			case addRecord:
			{
				addToBase(base);
				screen();
				break;
			}
			case findPhone:
			{
				phone(base);
				screen();
				break;
			}
			case findName:
			{
				name(base);
				screen();
				break;
			}
			case saveData:
			{
				saveBase(base, "base.dat");
				cout << endl;
				screen();
				break;
			}
		}
	}
}

int main()
{
	PeopleList *base = createList();

	loadBase(base, "base.dat");
	menu(base);

	deletePeopleList(base);
	return 0;
}