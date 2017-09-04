#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

int const stringSize = 256;

bool isEmptyString(char string[])
{
	int element = strlen(string) - 1;

	while ((element >= 0) && ((string[element] == ' ') || (string[element] == '\t') || (string[element] == '\r') || (string[element] == '\n')))
		element--;

	return element == -1;
}

int numberOfEmptyString(char toOpen[])
{
	fstream file;
	file.open(toOpen, ios::in);

	char string[stringSize] = {'\0'};
	int answer = 0;

	while (!file.eof())
	{
		file.getline(string, stringSize);
		answer += isEmptyString(string);
	}
	
	file.close();
	return answer;
}

int main()
{
	char toOpen[stringSize] = "string.txt";

	cout << "File " << toOpen << " include " << numberOfEmptyString(toOpen) << " empty string." << endl;

	return 0;
}