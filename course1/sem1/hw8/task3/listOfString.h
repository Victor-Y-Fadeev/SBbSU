#pragma once

#include "string.h"

struct ListOfString;

ListOfString* createListOfString();

void add(ListOfString *list, String *value, int repeat = 1);
void remove(ListOfString *list, String *value, int repeat = 1);
int countRepeatValue(ListOfString *list, String *value);
String *getValue(ListOfString *list, int number);
int size(ListOfString *list);
int numberOfAdded(ListOfString *list);
bool isEmpty(ListOfString *list);

void deleteListOfString(ListOfString *&list);