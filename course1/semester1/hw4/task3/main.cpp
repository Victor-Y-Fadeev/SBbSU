#include <iostream>
#include <string.h>
#include "stack.h"

using namespace std;

int const stringSize = 256;

void sortFacility(Stack *s, char token, char postfix[])
{
	if ((token >= '0') && (token <= '9'))
	{
		postfix[strlen(postfix)] = token;
		return;
	}

	if ((token == '*') || (token == '/'))
	{
		postfix[strlen(postfix)] = ' ';
		push(s, token);
		return;
	}

	if ((token == '+') || (token == '-'))
	{
		while ((peak(s) == '*') || (peak(s) == '/'))
		{
			postfix[strlen(postfix)] = ' ';
			postfix[strlen(postfix)] = pop(s);
		}
		postfix[strlen(postfix)] = ' ';
		push(s, token);
		return;
	}

	if (token == '(')
	{
		push(s, token);
		return;
	}

	if (token == ')')
	{
		while (peak(s) != '(')
		{
			postfix[strlen(postfix)] = ' ';
			postfix[strlen(postfix)] = pop(s);
		}
		pop(s);
	}
}

char *infixToPostfix(char infix[])
{
	Stack *s = createStack();
	char *postfix = new char[stringSize];
	for (int i = 0; i < stringSize; i++)
		postfix[i] = '\0';

	int infixSize = strlen(infix);
	for (int i = 0; i < infixSize; i++)
		sortFacility(s, infix[i], postfix);

	while (!emptyStack(s))
	{
		postfix[strlen(postfix)] = ' ';
		postfix[strlen(postfix)] = pop(s);
	}

	deleteStack(s);
	return postfix;
}

int main()
{
	char infix[stringSize] = {'\0'};

	cout << "Enter infix: ";
	cin.getline(infix, stringSize);

	cout << "Postfix: ";
	char *postfix = infixToPostfix(infix);
	cout << postfix << endl;

	delete[] postfix;
	return 0;
}