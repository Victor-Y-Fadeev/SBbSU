#pragma once

struct CircularList;

CircularList* createCricularList();
void add(CircularList *list, int value);
void remove(CircularList *list, int number);
int getValue(CircularList *list, int number);
void moveIterator(CircularList *list, int shift);
void removeIteratorElement(CircularList *list);
int getIteratorValue(CircularList *list);
int size(CircularList *list);
bool isEmpty(CircularList *list);
void deleteCircularList(CircularList *list);