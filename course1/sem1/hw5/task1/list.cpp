#include "list.h"
#include <limits.h>

struct ListElement
{
	int value;
	ListElement *next;
};

struct List
{
	ListElement *head;
	int size;
};

List *createList()
{
	List *list = new List;
	list->head = nullptr;
	list->size = 0;
	return list;
}

ListElement *createListElement(int value, ListElement *next)
{
	ListElement *newElement = new ListElement;
	newElement->value = value;
	newElement->next = next;
	return newElement;
}

void add(List *list, int value) 
{
	if (isEmpty(list))
	{
		list->head = createListElement(value, nullptr);
		list->size++;
		return;
	}

	if (list->head->value > value)
	{
		list->head = createListElement(value, list->head);
		list->size++;
		return;
	}
	
	ListElement *temp = list->head;
	while ((temp->next != nullptr) && (temp->next->value < value))
		temp = temp->next;

	temp->next = createListElement(value, temp->next);
	list->size++;
}

void remove(List *list, int value)
{
	if (isEmpty(list))
		return;

	ListElement *temp = list->head;
	if (temp->value == value)
	{
		list->head = temp->next;
		delete temp;
		list->size--;
		return;
	}
		
	while ((temp->next != nullptr) && (temp->next->value != value))
		temp = temp->next;
	
	if (temp->next == nullptr)
		return;
	
	ListElement *toDelete = temp->next;
	temp->next = toDelete->next;
	delete toDelete;
	list->size--;
}

int meaning(List *list, int number)
{
	if (number >= size(list))
		return INT_MIN;

	ListElement *temp = list->head;
	for (int i = 0; i < number; i++)
		temp = temp->next;

	return temp->value;
}

int size(List *list)
{
	return list->size;
}

bool isEmpty(List *list)
{
	return list->head == nullptr;
}

void deleteList(List *list)
{
	ListElement *temp = list->head;
	
	while (temp != nullptr)
	{
		ListElement *toDelete = temp;
		temp = temp->next;
		delete toDelete;
	}
	
	delete list;
}