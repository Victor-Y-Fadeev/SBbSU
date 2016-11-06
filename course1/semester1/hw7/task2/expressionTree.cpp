#include "expressionTree.h"
#include <fstream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

using namespace std;

int const stringSize = 256;

struct Node
{
	int value;
	char operation;
	Node *left;
	Node *right;
};

struct ExpressionTree
{
	Node *root;
};


ExpressionTree *createExpressionTree()
{
	ExpressionTree *newTree = new ExpressionTree;
	newTree->root = nullptr;
	return newTree;
}

Node *createNode(int value, char operation = '\0')
{
	Node *newNode = new Node;
	newNode->value = value;
	newNode->operation = operation;
	newNode->left = nullptr;
	newNode->right = nullptr;
	return newNode;
}


int getValue(char *string, int &i)
{
	char *temp = string + i;

	int j = 0;
	while ((temp[j] >= '0') && (temp[j] <= '9'))
		j++;

	char tempSymbol = temp[j];
	temp[j] = '\0';

	int answer = atoi(temp);
	temp[j] = tempSymbol;
	i += j;
	return answer;
}

void add(Node *&node, char *string, int &i)
{
	i++;
	node = createNode(0, string[i]);

	i += 2;
	if (string[i] == '(')
		add(node->left, string, i);
	else
		node->left = createNode(getValue(string, i));
	
	i++;
	if (string[i] == '(')
		add(node->right, string, i);
	else
		node->right = createNode(getValue(string, i));
	
	i++;
}

void loadExpression(ExpressionTree *tree, char *path)
{
	fstream file;
	file.open(path, ios::in);
	
	char *string = new char[stringSize];
	file.getline(string, stringSize);
	file.close();
	
	int i = 0;
	add(tree->root, string, i);

	delete[] string;
}


void addNumber(char *string, int number)
{
	char *temp = new char[stringSize];

	sprintf(temp, "%d", number);
	strcat(string, temp);
	delete[] temp;
}

char *outputExpression(Node *node)
{
	char *answer = new char[stringSize];
	strcpy(answer, "(");

	if (node->left->operation != '\0')
	{
		char *temp = outputExpression(node->left);
		strcat(answer, temp);
		delete[] temp;
	}
	else
		addNumber(answer, node->left->value);
	

	strcat(answer, " ");
	char temp[2] = {'\0'};
	temp[0] = node->operation;
	strcat(answer, temp);
	strcat(answer, " ");

	if (node->right->operation != '\0')
	{
		char *temp = outputExpression(node->right);
		strcat(answer, temp);
		delete[] temp;
	}
	else
		addNumber(answer, node->right->value);

	strcat(answer, ")");
	return answer;
}

char *outputExpression(ExpressionTree *tree)
{
	return outputExpression(tree->root);
}

int count(Node *node)
{
	int answer = 0;

	switch (node->operation)
	{
	case '\0':
		{
			answer = node->value;
			break;
		}

	case '+':
		{
			answer = count(node->left) + count(node->right);
			break;
		}
	case '-':
		{
			answer = count(node->left) - count(node->right);
			break;
		}
	case '*':
		{
			answer = count(node->left) * count(node->right);
			break;
		}
	case '/':
		{
			answer = count(node->left) / count(node->right);
			break;
		}
	}

	return answer;
}

int count(ExpressionTree *tree)
{
	return count(tree->root);
}


void deleteTree(Node *node)
{
	if (node == nullptr)
		return;

	deleteTree(node->left);
	deleteTree(node->right);
	delete node;
}

void deleteExpressionTree(ExpressionTree *&tree)
{
	deleteTree(tree->root);
	delete tree;
	tree = nullptr;
}