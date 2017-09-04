#include "stack.h"

int const minInt = -2147483648;

struct StackElement
{
	int data;
	StackElement *next;
};

struct Stack
{
	StackElement *top;
	int size;
};

Stack *createStack()
{
	Stack *s = new Stack;
	s->top = nullptr;
	s->size = 0;
	return s;
}

void push(Stack *s, int value)
{
	StackElement *newElement = new StackElement;
	newElement->data = value;
	newElement->next = s->top;
	s->top = newElement;
	s->size++;
}

int pop(Stack *s)
{
	if (emptyStack(s))
		return minInt;

	int x = s->top->data;
	StackElement *toDelete = s->top;
	s->top = s->top->next;
	delete toDelete;
	s->size--;
	return x;
}

int peak(Stack *s)
{
	if (emptyStack(s))
		return minInt;

	return s->top->data;
}

bool emptyStack(Stack *s)
{
	return s->top == nullptr;
}

StackElement *deleteStackElement(StackElement *e)
{
	if (e == nullptr)
		return nullptr;

	e->next = deleteStackElement(e->next);
	delete e;
	return nullptr;
}

void deleteStack(Stack *s)
{
	s->top = deleteStackElement(s->top);
}