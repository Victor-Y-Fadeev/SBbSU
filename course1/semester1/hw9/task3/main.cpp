#include <iostream>
#include <complex>
#include <string.h>

using namespace std;

int const stringSize = 256;

int hashFunction(char *string, int size)
{
	int hash = 0;

	for (int i = 0; i < size; i++)
		hash = 101 * hash + string[i];
	
	return hash;
}

void updateHash(int &hash, char *string, int i, int size, int numberInDegree)
{
	hash -= string[i] * numberInDegree;
	hash *= 101;
	hash += string[size + i];
}

bool isEqual(char *original, char *substring, int size, int i)
{
	bool answer = true;

	int j = 0;
	while ((answer) && (j < size))
	{
		if (original[i + j] != substring[j])
			answer = false;
		j++;
	}

	return answer;
}

void addNumber(char *string, int number)
{
	char *temp = new char[stringSize];

	sprintf(temp, "%d", number);
	strcat(string, temp);
	delete[] temp;

	strcat(string, " ");
}

char *rabinKarp(char *original, char *substring)
{
	char *answer = new char[stringSize];
	answer[0] = '\0';
	
	int originalSize = strlen(original);
	int substringSize = strlen(substring);
	int numberInDegree = pow(101, substringSize - 1);

	int hash = hashFunction(original, substringSize);
	int subHash = hashFunction(substring, substringSize);

	for (int i = 0; i <= originalSize - substringSize; i++)
	{
		if (hash == subHash)
			if (isEqual(original, substring, substringSize, i))
				addNumber(answer, i + 1);
		
		updateHash(hash, original, i, substringSize, numberInDegree);
	}

	if (answer[0] == '\0')
		strcpy(answer, "No matches");

	return answer;
}

int main()
{
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