#include "binaryTree.h"
#include <stdio.h>
#include <string.h>

int const stringSize = 256;

struct Node
{
	int value;
	Node *left;
	Node *right;
};

struct BinaryTree
{
	Node *root;
};


BinaryTree *createBinaryTree()
{
	BinaryTree *newTree = new BinaryTree;
	newTree->root = nullptr;
	return newTree;
}

Node *createNode(int value)
{
	Node *newNode = new Node;
	newNode->value = value;
	newNode->left = nullptr;
	newNode->right = nullptr;
	return newNode;
}


void add(Node *&node, int value)
{
	if (node == nullptr)
	{
		node = createNode(value);
		return;
	}

	if (node->value == value)
		return;

	if (node->value > value)
		add(node->left, value);
	else
		add(node->right, value);
}

void add(BinaryTree *tree, int value)
{
	add(tree->root, value);
}

void removeNode(Node *&node)
{
	if ((node->left == nullptr) && (node->right == nullptr))
	{
		delete node;
		node = nullptr;
		return;
	}

	if ((node->left != nullptr) && (node->right == nullptr))
	{
		Node *toDelete = node;
		node = node->left;
		delete toDelete;
		return;
	}

	if ((node->left == nullptr) && (node->right != nullptr))
	{
		Node *toDelete = node;
		node = node->right;
		delete toDelete;
		return;
	}

	if ((node->left != nullptr) && (node->right != nullptr))
	{
		Node **temp = &node->left;
		while ((*temp)->right != nullptr)
			temp = &(*temp)->right;
		node->value = (*temp)->value;
		removeNode(*temp);
		return;
	}
}

void remove(Node *&node, int value)
{
	if (node == nullptr)
		return;

	if (node->value == value)
	{
		removeNode(node);
		return;
	}

	if (node->value > value)
		remove(node->left, value);
	else
		remove(node->right, value);
}

void remove(BinaryTree *tree, int value)
{
	remove(tree->root, value);
}

bool exists(Node *node, int value)
{
	if (node == nullptr)
		return false;

	if (node->value == value)
		return true;

	if (node->value > value)
		return exists(node->left, value);
	else
		return exists(node->right, value);
}

bool exists(BinaryTree *tree, int value)
{
	return exists(tree->root, value);
}


void addNumber(char *string, int number)
{
	char *temp = new char[stringSize];

	sprintf(temp, "%d", number);
	strcat(string, temp);
	delete[] temp;
}

void addString(char *string, char *toAdd)
{
	strcat(string, toAdd);
	delete[] toAdd;
}

char *output(Node *node, bool route)
{
	if (node == nullptr)
	{
		char *emptyString = new char[stringSize];
		emptyString[0] = '\0';
		return emptyString;
	}

	Node *first = node->left;
	Node *last = node->right;
	if (route)
	{
		first = node->right;
		last = node->left;
	}
	
	char *answer = output(first, route);
	
	addNumber(answer, node->value);
	strcat(answer, " ");

	addString(answer, output(last, route));
	
	return answer;
}

char *increasingOutput(BinaryTree *tree)
{
	return output(tree->root, false);
}

char *decreasingOutput(BinaryTree *tree)
{
	return output(tree->root, true);
}

char *outputABC(Node *node)
{
	char *answer = new char[stringSize];
	answer[0] = '\0';

	if (node == nullptr)
	{
		strcpy(answer, "null");
		return answer;
	}
	
	strcpy(answer, "(");
	addNumber(answer, node->value);
	strcat(answer, " ");

	addString(answer, outputABC(node->left));
	strcat(answer, " ");

	addString(answer, outputABC(node->right));
	strcat(answer, ")");

	return answer;
}

char *outputABC(BinaryTree *tree)
{
	return outputABC(tree->root);
}


bool isEmpty(BinaryTree *tree)
{
	return tree->root == nullptr;
}

void deleteTree(Node *node)
{
	if (node == nullptr)
		return;

	deleteTree(node->left);
	deleteTree(node->right);
	delete node;
}

void deleteBinaryTree(BinaryTree *&tree)
{
	deleteTree(tree->root);
	delete tree;
	tree = nullptr;
}