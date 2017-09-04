#include <iostream>
#include "huffman.h"

using namespace std;

int main()
{
	HuffmanCode *huffman = loadFile("huffmanCode.txt");

	decryptHuffman(huffman);
	saveOriginalFile(huffman, "text.txt");
	
	deleteHuffmanCode(huffman);
	return 0;
}