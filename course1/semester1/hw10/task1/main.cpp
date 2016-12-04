#include <iostream>
#include "huffman.h"

using namespace std;

int main()
{
	HuffmanCode *huffman = readFile("text.txt");

	performHuffman(huffman);
	saveFile(huffman, "huffmanCode.txt");

	deleteHuffmanCode(huffman);
	return 0;
}