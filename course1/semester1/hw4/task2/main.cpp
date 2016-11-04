#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

int const stringSize = 256;
int const charSize = 256;

void word(char string[])
{
	char answer[stringSize] = {'\0'};
	bool elements[charSize] = {false};

	int stringSize = strlen(string);
	for (int i = 0; i < stringSize; i++)
	{
		if (!elements[(unsigned char)string[i]])
		{
			answer[strlen(answer)] = string[i];
			elements[(unsigned char)string[i]] = true;
		}
	}

	strcpy(string, answer);
}

int main()
{
	fstream file;
	file.open("input.txt");

	char string[stringSize] = {'\0'};
	while (!file.eof())
	{
		file >> string;
		word(string);
		cout << string << " ";
	}

	cout << endl;
	file.close();
	return 0;
}