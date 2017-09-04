#pragma once

struct TreeAVL;


TreeAVL *createTreeAVL();

void add(TreeAVL *tree, int value);
void remove(TreeAVL *tree, int value);
bool exists(TreeAVL *tree, int value);

char *increasingOutput(TreeAVL *tree);
char *decreasingOutput(TreeAVL *tree);
char *outputABC(TreeAVL *tree);

bool isEmpty(TreeAVL *tree);
void deleteTreeAVL(TreeAVL *&tree);