#include <iostream>
#include "rabinKarp.h"

using namespace std;

void output(int *answer)
{
	if (answer[0] == -1)
	{
		cout << "No matches" << endl;
		return;
	}

	int i = 0;
	cout << "Rabin-Karp algorithm: ";
	while (answer[i] != -1)
	{
		cout << answer[i] << " ";
		i++;
	}
	cout << endl;
}

int main()
{
	int const stringSize = 256;

	char string[stringSize] = {'\0'};
	char substring[stringSize] = {'\0'};

	cout << "Entre original string: ";
	cin.getline(string, stringSize);
	cout << "Enter substring: ";
	cin.getline(substring, stringSize);

	int answer[stringSize];
	rabinKarp(string, substring, answer);
	output(answer);	

	return 0;
}