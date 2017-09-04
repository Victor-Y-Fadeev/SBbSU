#include <iostream>
#include "list.h"

using namespace std;

void addToList(List *list)
{
	cout << "Enter added value: ";

	int n = 0;
	cin >> n;
	add(list, n);
	cout << endl;
}

void removeFromList(List *list)
{
	cout << "Enter removed value: ";

	int n = 0;
	cin >> n;
	remove(list, n);
	cout << endl;
}

void printList(List *list)
{
	if (isEmpty(list))
	{
		cout << "List is empty!" << endl;
		return;
	}

	cout << "List:";
	int s = size(list);

	for (int i = 0; i < s; i++)
		cout << " " << meaning(list, i);
	cout << endl << endl;
}

void screen()
{
	cout << "0 - exit;" << endl;
	cout << "1 - add a value to sorted list;" << endl;
	cout << "2 - remove a value from sorted list;" << endl;
	cout << "3 - print list." << endl << endl;
}

void menu(List *list)
{
	char ch = '\0';

	screen();
	while (ch != '0')
	{
		cin >> ch;
		switch (ch)
		{
			case '1':
			{
				addToList(list);
				screen();
				break;
			}
			case '2':
			{
				removeFromList(list);
				screen();
				break;
			}
			case '3':
			{
				printList(list);
				screen();
				break;
			}
		}
	}

}

int main()
{
	List *list = createList();

	menu(list);

	deleteList(list);
	return 0;
}