#include <iostream>
#include "string.h"

using namespace std;

void outputString(String *str)
{
	char *temp = toChar(str);
	cout << temp;
	delete temp;
}

int main()
{
	String *first = createString("abcde");	
	cout << "Init first string: ";
	outputString(first);
	
	String *second = clone(first);
	cout << endl << "Second string is clone of first: ";
	outputString(second);

	concatenation(first, second);
	cout << endl << "Concatenation string: ";
	outputString(first);

	if (isEquality(first, second))
		cout << endl << "First string is equality second";
	else
		cout << endl << "First string isn't equality second";
	
	if (isEmpty(first))
		cout << endl << "First string is empty";
	else
		cout << endl << "First string isn't empty";

	if (isSubstring(first, second))
		cout << endl << "Second string is substring of first";
	else
		cout << endl << "Second string isn't substring of first";

	cout << endl << "Size of first string: " << size(first) << endl;

	deleteString(first);
	deleteString(second);
	return 0;
}