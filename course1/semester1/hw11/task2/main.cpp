#include <iostream>
#include <string.h>
#include "lexicalAnalysis.h"
#include "syntacticAnalysis.h"

using namespace std;

int const stringSize = 1024;

int main()
{
	cout << "Enter testing string: ";
	char *string = new char[stringSize];
	string[0] = '\0';
	cin.getline(string, stringSize);
	
	Lexer *lexer = createLexer();
	char *temp = analyzeString(lexer, string);
	deleteLexer(lexer);

	if (strcmp(temp, "") != 0)
	{
		if (parseString(temp))
			cout << "Right string..." << endl;
		else
			cout << "Syntactic error!" << endl;
	}
	else
		cout << "Lexical error!" << endl;

	delete[] temp;
	delete[] string;
	return 0;
}