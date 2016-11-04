#include <iostream>
#include <string.h>
#include <stdlib.h>
#include "stack.h"

using namespace std;

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

int main()
{
	char postfix[stringSize] = {'\0'};

	cout << "Enter postfix: ";
	cin.getline(postfix, stringSize);
		
	cout << "Result: " << countPostfix(postfix) << endl;
	return 0;
}