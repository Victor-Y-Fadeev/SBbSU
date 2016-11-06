#include "treeAVL.h"
#include <stdio.h>
#include <string.h>

int const stringSize = 256;

struct Node
{
	int value;
	int height;
	Node *left;
	Node *right;
};

struct TreeAVL
{
	Node *root;
};


TreeAVL *createTreeAVL()
{
	TreeAVL *newTree = new TreeAVL;
	newTree->root = nullptr;
	return newTree;
}

Node *createNode(int value)
{
	Node *newNode = new Node;
	newNode->value = value;
	newNode->height = 1;
	newNode->left = nullptr;
	newNode->right = nullptr;
	return newNode;
}


int height(Node *node)
{
	if (node != nullptr)
		return node->height;
	else
		return 0;
}

int balanceFactor(Node *node)
{
	return height(node->right) - height(node->left);
}

void updateHeight(Node *node)
{
	int heightLeft = height(node->left);
	int heightRight = height(node->right);
	
	if (heightLeft > heightRight)
		node->height = heightLeft + 1;
	else
		node->height = heightRight + 1;
}

void rotateRight(Node *&node)
{
	Node *original = node;
	Node *temp = original->left;
	original->left = temp->right;
	temp->right = original;
	updateHeight(original);
	updateHeight(temp);
	node = temp;
}

void rotateLeft(Node *&node)
{
	Node *original = node;
	Node *temp = original->right;
	original->right = temp->left;
	temp->left = original;
	updateHeight(original);
	updateHeight(temp);
	node = temp;
}

void reBalans(Node *&node)
{
	if  (balanceFactor(node) == 2)
	{
		if (balanceFactor(node->right) == -1)
		{
			rotateRight(node->right);
			rotateLeft(node);
		}
		else
			rotateLeft(node);

		return;
	}

	if (balanceFactor(node) == -2)
	{
		if (balanceFactor(node->left) == 1)
		{
			rotateLeft(node->left);
			rotateRight(node);
		}
		else
			rotateRight(node);
	}
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

	updateHeight(node);
	reBalans(node);
}

void add(TreeAVL *tree, int value)
{
	add(tree->root, value);
}

void removeNode(Node *&node);

int removeRightest(Node *&node)
{
	if (node->right != nullptr)
	{
		int answer = removeRightest(node->right);
		updateHeight(node);
		reBalans(node);
		return answer;
	}
	else
	{
		int answer = node->value;
		removeNode(node);
		return answer;
	}
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
		node->value = removeRightest(node->left);
		updateHeight(node);
		reBalans(node);
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
	
	updateHeight(node);
	reBalans(node);
}

void remove(TreeAVL *tree, int value)
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

bool exists(TreeAVL *tree, int value)
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

char *increasingOutput(TreeAVL *tree)
{
	return output(tree->root, false);
}

char *decreasingOutput(TreeAVL *tree)
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

char *outputABC(TreeAVL *tree)
{
	return outputABC(tree->root);
}


bool isEmpty(TreeAVL *tree)
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

void deleteTreeAVL(TreeAVL *&tree)
{
	deleteTree(tree->root);
	delete tree;
	tree = nullptr;
}