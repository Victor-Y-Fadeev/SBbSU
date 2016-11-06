#include "hashTable.h"
#include "listOfString.h"
#include "string.h"
#include <fstream>

using namespace std;

int const tableSize = 1024;
int const stringSize = 256;

struct HashTable
{
	ListOfString **table;
	ListOfString *maxCell;
	int addedWord;
	int emptyCell;
	int size;
};

HashTable *createHash()
{
	HashTable *newHashTable = new HashTable;
	
	newHashTable->table = new ListOfString*[tableSize];
	for (int i = 0; i < tableSize; i++)
		newHashTable->table[i] = nullptr;

	newHashTable->maxCell = nullptr;
	newHashTable->addedWord = 0;
	newHashTable->emptyCell = tableSize;
	newHashTable->size = tableSize;

	return newHashTable;
}


unsigned int hashFunction(String *word, int mod)
{
	char *temp = toChar(word);
	int wordSize = size(word);

	unsigned int hash = 2139062143;
	for (int i = 0; i < wordSize; i++)
		hash = 37 * hash + temp[i];

	delete[] temp;
	return hash % mod;
}

void addToResizeTable(HashTable *hashTable, String *word, int repeat)
{
	int hash = hashFunction(word, hashTable->size);
	
	if (hashTable->table[hash] == nullptr)
	{
		hashTable->table[hash] = createListOfString();
		hashTable->emptyCell--;
	}

	add(hashTable->table[hash], word, repeat);
	
	if ((hashTable->maxCell == nullptr) || (numberOfAdded(hashTable->table[hash]) > numberOfAdded(hashTable->maxCell)))
		hashTable->maxCell = hashTable->table[hash];
}

void resize(HashTable *hashTable)
{
	ListOfString **temp = hashTable->table;
	int oldSize = hashTable->size;
	
	hashTable->size = 2 * oldSize;
	hashTable->table = new ListOfString*[hashTable->size];
	hashTable->emptyCell = hashTable->size;
	hashTable->maxCell == nullptr;

	for (int i = 0; i < hashTable->size; i++)
		hashTable->table[i] = nullptr;

	for (int i = 0; i < oldSize; i++)
	{
		if (temp[i] == nullptr)
			continue;

		int listSize = size(temp[i]);
		for (int j = 0; j < 1; j++)
		{
			String *word = getValue(temp[i], j);
			int repeat = countRepeatValue(temp[i], word);
			addToResizeTable(hashTable, word, repeat);
			deleteString(word);
		}
		deleteListOfString(temp[i]);
	}
	delete[] temp;
}

void addWord(HashTable *hashTable, String *word)
{
	if (loadFactor(hashTable) > 5)
		resize(hashTable);

	int hash = hashFunction(word, hashTable->size);

	if (hashTable->table[hash] == nullptr)
	{
		hashTable->table[hash] = createListOfString();
		hashTable->emptyCell--;
	}

	add(hashTable->table[hash], word);
	hashTable->addedWord++;

	if ((hashTable->maxCell == nullptr) || (numberOfAdded(hashTable->table[hash]) > numberOfAdded(hashTable->maxCell)))
		hashTable->maxCell = hashTable->table[hash];
}

void loadFile(HashTable *hashTable, char *path)
{
	fstream file;
	file.open(path, ios::in);

	char *string = new char[stringSize];

	while (!file.eof())
	{
		file >> string;
		String *word = createString(string);
		addWord(hashTable, word);
		deleteString(word);
	}

	delete[] string;
	file.close();
}

float loadFactor(HashTable *hashTable)
{
	return (float)hashTable->addedWord / hashTable->size;
}

float sizeOfMiddleChain(HashTable *hashTable)
{
	return (float)hashTable->addedWord / (hashTable->size - hashTable->emptyCell);
}

int sizeOfMaxChain(HashTable *hashTable)
{
	return numberOfAdded(hashTable->maxCell);
}

char *maxChain(HashTable *hashTable)
{
	int listSize = size(hashTable->maxCell);	
	String *str = createString("");
	String *space = createString(" ");
	
	for (int i = 0; i < listSize; i++)
	{
		String *temp = getValue(hashTable->maxCell, i);
		concatenation(str, temp);
		concatenation(str, space);
		deleteString(temp);
	}

	char *answer = toChar(str);
	deleteString(str);
	deleteString(space);
	return answer;
}

int sizeOfAddedWord(HashTable *hashTable)
{
	return hashTable->addedWord;
}

int sizeOfEmptyCell(HashTable *hashTable)
{
	return hashTable->emptyCell;
}


void deleteHash(HashTable *&hashTable)
{
	for (int i = 0; i < hashTable->size; i++)
		if (hashTable->table[i] != nullptr)
			deleteListOfString(hashTable->table[i]);
	
	delete hashTable;
	hashTable = nullptr;
}