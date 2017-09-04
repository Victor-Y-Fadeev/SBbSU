#pragma once

struct List;

List* createList();
void add(List *list, int value);
void remove(List *list, int value);
int meaning(List *list, int number);
int size(List *list);
bool isEmpty(List *list);
void deleteList(List *list);