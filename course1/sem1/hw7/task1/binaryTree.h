#pragma once

struct BinaryTree;


BinaryTree *createBinaryTree();

void add(BinaryTree *tree, int value);
void remove(BinaryTree *tree, int value);
bool exists(BinaryTree *tree, int value);

char *increasingOutput(BinaryTree *tree);
char *decreasingOutput(BinaryTree *tree);
char *outputABC(BinaryTree *tree);

bool isEmpty(BinaryTree *tree);
void deleteBinaryTree(BinaryTree *&tree);