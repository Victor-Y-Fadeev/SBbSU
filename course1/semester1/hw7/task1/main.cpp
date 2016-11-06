#include <iostream>
#include "binaryTree.h"

using namespace std;

enum Dialog
{
	programExit = '0',
	addRecord,
	removeRecord,
	findRecord,
	printIncreasing,
	printDecreasing,
	printABC
};

void addValue(BinaryTree *tree)
{
	cout << "Enter added value: ";

	int value = 0;
	cin >> value;
	add(tree, value);

	cout << endl;
}

void removeValue(BinaryTree *tree)
{
	cout << "Enter removed value: ";

	int value = 0;
	cin >> value;
	remove(tree, value);

	cout << endl;
}

void findValue(BinaryTree *tree)
{
	cout << "Enter found value: ";

	int value = 0;
	cin >> value;
	
	if (exists(tree, value))
		cout << "Is found" << endl << endl;
	else
		cout << "Isn't found" << endl << endl;
}

void outputIncreasing(BinaryTree *tree)
{
	cout << "Value in increasing order: ";
	
	char *temp = increasingOutput(tree);
	cout << temp << endl;
	delete[] temp; 
	
	cout << endl;
}

void outputDecreasing(BinaryTree *tree)
{
	cout << "Value in decreasing order: ";
	
	char *temp = decreasingOutput(tree);
	cout << temp << endl;
	delete[] temp;
	
	cout << endl;
}

void outputFormatABC(BinaryTree *tree)
{
	cout << "Value in (a b c) format: ";
	
	char *temp = outputABC(tree);
	cout << temp << endl;
	delete[] temp;

	cout << endl;
}

void screen()
{
	cout << (char)programExit << " - exit;" << endl;
	cout << (char)addRecord << " - add value;" << endl;
	cout << (char)removeRecord << " - remove value;" << endl;
	cout << (char)findRecord << " - find value;" << endl;
	cout << (char)printIncreasing << " - print in increasing order;" << endl;
	cout << (char)printDecreasing << " - print in decreasing order;" << endl;
	cout << (char)printABC << " - print in (a b c) format" << endl << endl;
}

void menu(BinaryTree *tree)
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
				addValue(tree);
				screen();
				break;
			}
			case removeRecord:
			{
				removeValue(tree);
				screen();
				break;
			}
			case findRecord:
			{
				findValue(tree);
				screen();
				break;
			}
			case printIncreasing:
			{
				outputIncreasing(tree);
				screen();
				break;
			}
			case printDecreasing:
			{
				outputDecreasing(tree);
				screen();
				break;
			}
			case printABC:
			{
				outputFormatABC(tree);
				screen();
				break;
			}
		}
	}
}

int main()
{
	BinaryTree *tree = createBinaryTree();

	menu(tree);

	deleteBinaryTree(tree);
	return 0;
}