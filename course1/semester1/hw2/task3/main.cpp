#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

const int stringSize = 256;

int min(int x, int y)
{
	if (x < y)
		return x;
	else
		return y;
}

void sum(char output[], int n, int max)
{
	if (n == 0)
		cout << output << endl;

	for (int i = min(n, max); i > 0; i--)
	{
		char number[stringSize] = {'\0'};
		char temp[stringSize] = {'\0'};

		sprintf(number, "%d", i);
		strcpy(temp, output);
		strcat(temp, " + ");
		strcat(temp, number);

		sum(temp, n - i, i);
	}
}

void sumStart(int n)
{
	char output[stringSize] = {'\0'};

	sprintf(output, "%d", n);
	strcat(output, " = ");

	for (int i = n; i > 0; i--)
	{
		char number[stringSize] = {'\0'};
		char temp[stringSize] = {'\0'};

		sprintf(number, "%d", i);
		strcpy(temp, output);
		strcat(temp, number);

		sum(temp, n - i, i);
	}
}

int main()
{
	int n = 0;

	cout << "Enter N: ";
	cin >> n;
	sumStart(n);

	return 0;
}