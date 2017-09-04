#include <iostream>
#include <string.h>

using namespace std;

int main()
{
	int const stringSize = 256;
	char number[stringSize] = {'\0'};

	cout << "Enter number: ";
	cin >> number;

	int	numeral[10] = {0};
	int numberSize = strlen(number);
	for (int i = 0; i < numberSize; i++)
		numeral[number[i] - '0']++;

	cout << "Smallest number: ";
	int i = 1;
	while ((i < 10) && (numeral[i] == 0))
		i++;
	if (i < 10)
	{
		cout << i;
		numeral[i]--;
	}
		for (int j = 0; j < 10; j++)
		for (int k = 0; k < numeral[j]; k++)
			cout << j;

	cout << endl;
	return 0;
}