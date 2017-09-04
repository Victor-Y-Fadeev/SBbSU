#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

int const stringSize = 256;

char *powers(char polynomial[], int mas[], int size)
{
	char *answer = new char[stringSize];
	strcpy(answer, " ");

	int lenth = strlen(polynomial);
	int pow = size - 1;
	int i = 0;

	while ((i < lenth) && (pow > 1))
	{
		if (mas[size - 1 - pow] == 0)
			pow--;

		if (mas[size - 1 - pow] != 0)
		{
			if (polynomial[i] == 'x')
			{
				char temp[stringSize] = { '\0' };
				sprintf(temp, "%d", pow);
				strcat(answer, temp);
				if (pow >= 10)
					i++;
				pow--;
			}
			else
				strcat(answer, " ");
			i++;
		}
	}

	return answer;
}

void clearOutput(int mas[], int size)
{
	char polynomial[stringSize] = { '\0' };

	for (int i = 0; i < size; i++)
	{
		if ((mas[i] == 0) && (size != 1))
			continue;

		if ((mas[i] > 0) && (i != 0))
			strcat(polynomial, "+ ");

		if (mas[i] < 0)
		{
			strcat(polynomial, "-");
			if (i != 0)
				strcat(polynomial, " ");
			mas[i] = -mas[i];
		}

		if ((mas[i] != 1) || (size == 1) || (i == size - 1))
		{
			char temp[stringSize] = { '\0' };
			sprintf(temp, "%d", mas[i]);
			strcat(polynomial, temp);
		}

		if (i != size - 1)
			strcat(polynomial, "x ");

		if (size - i >= 10)
			strcat(polynomial, " ");
	}

	char *powersString = powers(polynomial, mas, size);
	cout << powersString << endl << polynomial << endl;
	delete[] powersString;
}

int main()
{
	int size = 0;
	cout << "Enter power of polynomial: ";
	cin >> size;
	size++;

	int *mas = new int[size];
	cout << "Enter coefficients of polynomial: ";
	for (int i = 0; i < size; i++)
		cin >> mas[i];

	cout << endl;
	clearOutput(mas, size);

	delete[] mas;
	return 0;
}