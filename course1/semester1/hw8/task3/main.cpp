#include <iostream>
#include "hashTable.h"

using namespace std;

int main()
{
	HashTable *hash = createHash();
	
	loadFile(hash, "text.txt");
	cout << "Load factor: " << loadFactor(hash) << endl;
	cout << "Middle size of chain: " << sizeOfMiddleChain(hash) << endl;
	cout << "Max size of chain: " << sizeOfMaxChain(hash) << endl;
	char *temp = maxChain(hash);
	cout << "Max chain: " << temp << endl;
	delete[] temp;
	cout << "Number of added word: " << sizeOfAddedWord(hash) << endl;
	cout << "Number of empty cell: " << sizeOfEmptyCell(hash) << endl;
	
	deleteHash(hash);
	return 0;
}