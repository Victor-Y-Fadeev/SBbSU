#include <iostream>
#include "lexicalAnalysis.h"

using namespace std;

int const stringSize = 1024;

int main()
{
	Lexer *lexer = createLexer();

	cout << "Enter testing string: ";
	char string[stringSize] = {'\0'};
	cin.getline(string, stringSize);

	char *temp = analyzeString(lexer, string);
	cout << "Result: " << temp << endl;
	delete[] temp;
 
	deleteLexer(lexer);
	return 0;
}