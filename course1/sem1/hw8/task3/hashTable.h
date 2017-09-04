#pragma once

struct HashTable;

HashTable *createHash();

void loadFile(HashTable *hashTable, char *path);
float loadFactor(HashTable *hashTable);
float sizeOfMiddleChain(HashTable *hashTable);
int sizeOfMaxChain(HashTable *hashTable);
char *maxChain(HashTable *hashTable);
int sizeOfAddedWord(HashTable *hashTable);
int sizeOfEmptyCell(HashTable *hashTable);

void deleteHash(HashTable *&hashTable);