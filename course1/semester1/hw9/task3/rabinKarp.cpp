#include "rabinKarp.h"
#include <complex>
#include <string.h>

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

void rabinKarp(char *original, char *substring, int *answer)
{
	int originalSize = strlen(original);
	int substringSize = strlen(substring);
	int numberInDegree = pow(101, substringSize - 1);

	int hash = hashFunction(original, substringSize);
	int subHash = hashFunction(substring, substringSize);

	int answerElement = 0;
	for (int i = 0; i <= originalSize - substringSize; i++)
	{
		if (hash == subHash)
		{
			if (isEqual(original, substring, substringSize, i))
			{
				answer[answerElement] = i + 1;
				answerElement++;
			}
		}

		updateHash(hash, original, i, substringSize, numberInDegree);
	}

	answer[answerElement] = -1;
}