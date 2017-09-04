#include "calculator.h"
#include <string.h>
#include <stdlib.h>
#include "stack.h"

int const stringSize = 256;

void toCount(Stack *s, char *token)
{
	if ((token[0] >= '0') && (token[0] <= '9'))
	{
		push(s, atoi(token));
		return;
	}

	switch (token[0])
	{
	case '+':
	{
		int temp = pop(s);
		temp += pop(s);
		push(s, temp);
		break;
	}
	case '-':
	{
		int temp = 0 - pop(s);
		temp += pop(s);
		push(s, temp);
		break;
	}
	case '*':
	{
		int temp = pop(s);
		temp *= pop(s);
		push(s, temp);
		break;
	}
	case '/':
	{
		float temp = 1.0 / pop(s);
		temp *= pop(s);
		push(s, (int)temp);
		break;
	}
	}
}

int countPostfix(char postfix[])
{
	Stack *s = createStack();

	int postfixSize = strlen(postfix);
	int i = 0;
	while (i < postfixSize)
	{
		char temp[stringSize] = { '\0' };
		temp[0] = postfix[i];
		i++;

		while ((postfix[i] >= '0') && (postfix[i] <= '0'))
		{
			temp[strlen(temp)] = postfix[i];
			i++;
		}

		toCount(s, temp);
	}

	int answer = pop(s);
	deleteStack(s);
	return answer;
}

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

int calculator(char string[])
{
	char *postfix = infixToPostfix(string);
	int answer = countPostfix(postfix);
	delete[] postfix;
	return answer;
}