#include <iostream>

struct Node
{
	char info = ' ';
	Node *next = nullptr;
};

struct Stack
{
	Node *data;

	void add(char symbol)
	{
		Node *temporary = new Node;

		temporary->info = symbol;
		temporary->next = data;
		data = temporary;		
	}

	void remove()
	{
		Node *temporary = data;

		data = data->next;

		delete temporary;
	}

	char read()
	{
		return data->info;
	}

	~Stack()
	{
		while (data != nullptr)
		{
			remove();
		}
	}
};

void testBrackets(Stack &stack, bool &check, char symbol, char begin, char end)
{
	if (symbol == begin)
	{
		stack.add(begin);
	}
	
	if (symbol == end)
	{
		if ((stack.data != nullptr) && (stack.read() == begin))
		{
			stack.remove();
		}
		else {
			check = 1;
		}
	}	
}

int main()
{
	Stack stack = {nullptr};
	char string[256] = "";

	printf("Enter string: ");
	scanf("%s", &string);

	bool checkRule = 0;
	int i = 0;
	while ((string[i] != '\0') && (!checkRule))
	{
		testBrackets(stack, checkRule, string[i], '(', ')');
		testBrackets(stack, checkRule, string[i], '[', ']');
		testBrackets(stack, checkRule, string[i], '{', '}');
		testBrackets(stack, checkRule, string[i], '<', '>');
		i++;
	}

	if ((!checkRule) && (stack.data == nullptr))
	{
		printf("Ok \n");
	}
	else {
		printf("All bad \n");
	}
}
