#include <iostream>
#include "rabinKarp.h"

using namespace std;

int main()
{
	int const stringSize = 256;

	char string[stringSize] = {'\0'};
	char substring[stringSize] = {'\0'};

	cout << "Entre original string: ";
	cin.getline(string, stringSize);
	cout << "Enter substring: ";
	cin.getline(substring, stringSize);

	char *answer = rabinKarp(string, substring);
	cout << "Rabin-Karp algorithm: " << answer << endl;

	delete[] answer;
	return 0;
}