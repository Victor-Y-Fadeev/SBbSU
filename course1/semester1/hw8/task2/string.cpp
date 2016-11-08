#include "string.h"
#include <string.h>

struct String
{
	char *string;
	int size;
};


String *createString(char *string)
{
	String *newString = new String;

	newString->size = strlen(string);
	newString->string = new char[newString->size + 1];
	strcpy(newString->string, string);
	newString->string[newString->size] = '\0';

	return newString;
}

String *clone(String *string)
{
	return createString(string->string);
}


void concatenation(String *original, String *added)
{
	original->size = original->size + added->size;
	char *temp = new char[original->size + 1];

	strcpy(temp, original->string);
	strcat(temp, added->string);
	temp[original->size] = '\0';

	delete[] original->string;
	original->string = temp;
}

bool isEquality(String *first, String *second)
{
	return strcmp(first->string, second->string) == 0;
}

bool isEmpty(String *string)
{
	return size(string) == 0;
}

bool isSubstring(String *string, String *substring)
{
	return strstr(string->string, substring->string) != nullptr;
}

int size(String *string)
{
	return string->size;
}

char *toChar(String *string)
{
	char *toReturn = new char[string->size + 1];
	strcpy(toReturn, string->string);

	return toReturn;
}


void deleteString(String *&string)
{
	delete[] string->string;
	delete string;
	string = nullptr;
}