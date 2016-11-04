#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

int const stringSize = 256;

bool checkDoubleMark(char *string, int size, int i, char *commentType)
{
	return (size > i + 1) && (string[i] == commentType[0]) && (string[i + 1] == commentType[1]);
}

void outputComment(char *string, int size, int &i)
{
	if (!checkDoubleMark(string, size, i, "//"))
		return;

	while (i < size)
	{
		cout << string[i];
		i++;
	}

	cout << endl;
}

void testBigComment(fstream &file, char *&string, int &size, int &i)
{
	if (!checkDoubleMark(string, size, i, "/*"))
		return;

	i += 2;
	while (!file.eof() && !checkDoubleMark(string, size, i, "*/"))
	{
		while ((i < size - 1) && !checkDoubleMark(string, size, i, "*/"))
			i++;

		if (!checkDoubleMark(string, size, i, "*/"))
		{
			file.getline(string, stringSize);
			size = strlen(string);
			i = 0;
		}
	}
	i++;
}

void testQuotes(char *string, int size, int &i, char quote)
{
	if (string[i] != quote)
		return;

	i++;
	char temp[2] = {'\\', quote};
	while ((i < size) && ((string[i] != quote) || checkDoubleMark(string, size, i - 1, temp)))
		i++;
}

int main()
{
	fstream file;
	file.open("code.txt");
	
	char *string = new char[stringSize];
	string[0] = '\0';
	while (!file.eof())
	{
		file.getline(string, stringSize);
		int size = strlen(string);
		int i = 0;

		while (i < size - 1)
		{
			testQuotes(string, size, i, '\'');
			testQuotes(string, size, i, '\"');
			testBigComment(file, string, size, i);
			outputComment(string, size, i);
			i++;
		}

	}
	
	delete[] string;
	file.close();
	return 0;
}