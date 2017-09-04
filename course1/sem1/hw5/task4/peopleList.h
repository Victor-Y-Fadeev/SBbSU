#pragma once

struct PeopleList;

PeopleList* createList();
void add(PeopleList *list, char *name, int phone);
char *findNameByPhone(PeopleList *list, int phone);
int findPhoneByName(PeopleList *list, char *name);
char *getValue(PeopleList *list, int n, int &phone);
int size(PeopleList *list);
bool isEmpty(PeopleList *list);
void deletePeopleList(PeopleList *list);