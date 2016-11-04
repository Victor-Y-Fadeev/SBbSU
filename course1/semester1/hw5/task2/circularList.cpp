#include "circularList.h"
#include <limits.h>

struct ListElement
{
	int value;
	ListElement *next;
};

struct CircularList
{
	ListElement *head;
	int size;
	ListElement *iterator;
};

CircularList *createCricularList()
{
	CircularList *list = new CircularList;
	list->head = nullptr;
	list->size = 0;
	list->iterator = nullptr;
	return list;
}

ListElement *createListElement(int value, ListElement *next)
{
	ListElement *newElement = new ListElement;
	newElement->value = value;
	newElement->next = next;
	return newElement;
}

void addToEmpty(CircularList *list, int value)
{
	list->head = createListElement(value, nullptr);
	list->head->next = list->head;
	list->iterator = list->head;
	list->size++;
}

void addFirst(CircularList *list, int value)
{
	ListElement *temp = list->head;
	while (temp->next != list->head)
		temp = temp->next;
	list->head = createListElement(value, list->head);
	
	if (list->iterator->next == list->head->next)
		list->iterator = list->head;
	
	temp->next = list->head;
	list->size++;
}

void add(CircularList *list, int value) 
{
	if (isEmpty(list))
	{
		addToEmpty(list, value);
		return;
	}

	if (list->head->value > value)
	{
		addFirst(list, value);
		return;
	}
	
	ListElement *temp = list->head;
	while ((temp->next != list->head) && (temp->next->value < value))
		temp = temp->next;

	temp->next = createListElement(value, temp->next);
	if (temp == list->iterator)
		list->iterator = temp->next;

	list->size++;
}

void removeNextElement(ListElement *temp)
{
	ListElement *toDelete = temp->next;
	temp->next = toDelete->next;
	delete toDelete;
}

void removeFirst(CircularList *list)
{
	ListElement *temp = list->head;
	while (temp->next != list->head)
		temp = temp->next;
	
	if (list->iterator == temp->next)
		list->iterator = temp;
	removeNextElement(temp);
	list->head = temp->next;
	list->size--;
}

void remove(CircularList *list, int number)
{
	if (isEmpty(list))
		return;

	ListElement *temp = list->head;
	if (number % size(list) == 0)
	{
		removeFirst(list);
		return;
	}

	if (temp->next == temp)
	{
		delete temp;
		return;
	}

	for (int i = 0; i < number - 1; i++)
		temp = temp->next;
	
	if (list->iterator == temp->next)
		list->iterator = temp;
	removeNextElement(temp);
	list->size--;
}

int getValue(CircularList *list, int number)
{
	if (isEmpty(list))
		return INT_MIN;

	ListElement *temp = list->head;
	for (int i = 0; i < number; i++)
		temp = temp->next;

	return temp->value;
}

void moveIterator(CircularList *list, int shift)
{
	for (int i = 0; i < shift; i++)
		list->iterator = list->iterator->next;
}

void removeIteratorElement(CircularList *list)
{
	if (isEmpty(list))
		return;

	if (list->iterator->next == list->head)
	{
		removeFirst(list);
		return;
	}

	removeNextElement(list->iterator);
}

int getIteratorValue(CircularList *list)
{
	return list->iterator->next->value;
}

int size(CircularList *list)
{
	return list->size;
}

bool isEmpty(CircularList *list)
{
	return list->head == nullptr;
}

void deleteCircularList(CircularList *list)
{
	ListElement *temp = list->head->next;
	
	while (temp != list->head)
	{
		ListElement *toDelete = temp;
		temp = temp->next;
		delete toDelete;
	}

	delete temp;
	delete list;
}