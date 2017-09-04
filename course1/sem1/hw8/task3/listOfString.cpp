#include "listOfString.h"
#include "string.h"

struct ListElement
{
	int repeat;
	String *value;
	ListElement *next;
};

struct ListOfString
{
	ListElement *head;
	int size;
	int nuberOfAdded;
};

ListOfString *createListOfString()
{
	ListOfString *list = new ListOfString;
	list->head = nullptr;
	list->size = 0;
	list->nuberOfAdded = 0;
	return list;
}

ListElement *createListElement(String *value, ListElement *next, int repeat = 1)
{
	ListElement *newElement = new ListElement;
	String *newString = clone(value);
	newElement->repeat = repeat;
	newElement->value = newString;
	newElement->next = next;
	return newElement;
}

void add(ListOfString *list, String *value, int repeat)
{
	list->nuberOfAdded += repeat;

	if (isEmpty(list))
	{
		list->head = createListElement(value, nullptr, repeat);
		list->size++;
		return;
	}
	
	if (isEquality(list->head->value, value))
	{
		list->head->repeat += repeat;
		return;
	}

	ListElement *temp = list->head;
	while ((temp->next != nullptr) && !isEquality(temp->next->value, value))
		temp = temp->next;

	if (temp->next == nullptr)
	{
		temp->next = createListElement(value, nullptr, repeat);
		list->size++;
	}
	else
		temp->next->repeat += repeat;
}

void remove(ListOfString *list, String *value, int repeat)
{
	if (isEmpty(list))
		return;

	ListElement *temp = list->head;
	if (isEquality(temp->value, value))
	{
		list->nuberOfAdded -= repeat;

		if (temp->repeat == repeat)
		{
			list->head = temp->next;
			delete temp;
			list->size--;
		}
		else
			temp->repeat -= repeat;
		return;
	}
		
	while ((temp->next != nullptr) && !isEquality(temp->next->value, value))
		temp = temp->next;
	
	if (temp->next == nullptr)
		return;

	if (temp->next->repeat == repeat)
	{
		ListElement *toDelete = temp->next;
		temp->next = toDelete->next;
		delete toDelete;
		list->size--;
	}
	else
		temp->next->repeat -= repeat;

	list->nuberOfAdded -= repeat;
}

int countRepeatValue(ListOfString *list, String *value)
{
	ListElement *temp = list->head;
	
	while ((temp != nullptr) && !isEquality(temp->value, value))
		temp = temp->next;

	if (temp == nullptr)
		return 0;
	else
		return temp->repeat;
}

String *getValue(ListOfString *list, int number)
{
	if (number >= size(list))
		return createString("");

	ListElement *temp = list->head;
	for (int i = 0; i < number; i++)
		temp = temp->next;

	String *answer = clone(temp->value);
	return answer;
}

int size(ListOfString *list)
{
	return list->size;
}

int numberOfAdded(ListOfString *list)
{
	return list->nuberOfAdded;
}

bool isEmpty(ListOfString *list)
{
	return list->head == nullptr;
}

void deleteListOfString(ListOfString *&list)
{
	ListElement *temp = list->head;
	
	while (temp != nullptr)
	{
		ListElement *toDelete = temp;
		temp = temp->next;
		deleteString(toDelete->value);
		delete toDelete;
	}
	
	delete list;
	list = nullptr;
}