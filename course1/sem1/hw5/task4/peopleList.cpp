#include "peopleList.h"
#include <string.h>
#include <limits.h>

struct ListElement
{
	char *name;
	int phone;
	ListElement *next;
};

struct PeopleList
{
	ListElement *head;
	int size;
};

PeopleList *createList()
{
	PeopleList *list = new PeopleList;
	list->head = nullptr;
	list->size = 0;
	return list;
}

ListElement *createListElement(char *name, int phone, ListElement *next)
{
	ListElement *newElement = new ListElement;
	newElement->name = name;
	newElement->phone = phone;
	newElement->next = next;
	return newElement;
}

void add(PeopleList *list, char *name, int phone)
{
	if (isEmpty(list))
	{
		list->head = createListElement(name, phone, nullptr);
		list->size++;
		return;
	}

	if (list->head->phone > phone)
	{
		list->head = createListElement(name, phone, list->head);
		list->size++;
		return;
	}
	
	ListElement *temp = list->head;
	while ((temp->next != nullptr) && (temp->next->phone < phone))
		temp = temp->next;

	temp->next = createListElement(name, phone, temp->next);
	list->size++;
}

char *findNameByPhone(PeopleList *list, int phone)
{
	if (isEmpty(list))
		return "";
	
	ListElement *temp = list->head;
	while ((temp != nullptr) && (temp->phone < phone))
		temp = temp->next;
	
	if ((temp == nullptr) || (temp->phone != phone))
		return "";
	
	return temp->name;
}

int findPhoneByName(PeopleList *list, char *name)
{
	if (isEmpty(list))
		return INT_MIN;

	ListElement *temp = list->head;
	while ((temp != nullptr) && (strcoll(temp->name, name) != 0))
		temp = temp->next;

	if (temp == nullptr)
		return INT_MIN;

	return temp->phone;
}

char *getValue(PeopleList *list, int n, int &phone)
{
	if (n >= size(list))
		return "";

	ListElement *temp = list->head;
	for (int i = 0; i < n; i++)
		temp = temp->next;

	phone = temp->phone;
	return temp->name;
}

int size(PeopleList *list)
{
	return list->size;
}

bool isEmpty(PeopleList *list)
{
	return list->head == nullptr;
}

void deletePeopleList(PeopleList *list)
{
	ListElement *temp = list->head;
	
	while (temp != nullptr)
	{
		ListElement *toDelete = temp;
		temp = temp->next;
		delete[] toDelete->name;
		delete toDelete;
	}
	
	delete list;
}