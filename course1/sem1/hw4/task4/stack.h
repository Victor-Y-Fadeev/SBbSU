#pragma once

struct Stack;

Stack* createStack();
void push(Stack *s, int value);
int pop(Stack *s);
int peak(Stack *s);
bool emptyStack(Stack *s);
void deleteStack(Stack *s);
