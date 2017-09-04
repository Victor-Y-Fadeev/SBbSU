#include "priorityQueue.h"
#include <limits.h>

struct Node
{
	int key;
	int value;
	Node *next;
};

struct PriorityQueue
{
	Node *head;
};


PriorityQueue *createPriorityQueue()
{
	PriorityQueue *newPriorityQueue = new PriorityQueue;
	newPriorityQueue->head = nullptr;
	return newPriorityQueue;
}


Node *createNode(int key, int value, Node *next)
{
	Node *newNode = new Node;
	newNode->key = key;
	newNode->value = value;
	newNode->next = next;
	return newNode;
}

void add(PriorityQueue *priorityQueue, int key, int value)
{
	if (isEmpty(priorityQueue))
	{
		priorityQueue->head = createNode(key, value, nullptr);
		return;
	}

	if (priorityQueue->head->key > key)
	{
		priorityQueue->head = createNode(key, value, priorityQueue->head);
		return;
	}

	Node *temp = priorityQueue->head;
	while ((temp->next != nullptr) && (temp->next->key < key))
		temp = temp->next;

	temp->next = createNode(key, value, temp->next);
}


void remove(PriorityQueue *priorityQueue, int value)
{
	if (isEmpty(priorityQueue))
		return;

	Node *temp = priorityQueue->head;
	if (temp->value == value)
	{
		priorityQueue->head = temp->next;
		delete temp;
		return;
	}

	while ((temp->next != nullptr) && (temp->next->value != value))
		temp = temp->next;

	if (temp->next == nullptr)
		return;

	Node *toDelete = temp->next;
	temp->next = toDelete->next;
	delete toDelete;
}

void insert(PriorityQueue *priorityQueue, int key, int value)
{
	remove(priorityQueue, value);
	add(priorityQueue, key, value);
}

int extractMinimum(PriorityQueue *priorityQueue)
{
	if (isEmpty(priorityQueue))
		return INT_MIN;

	Node *temp = priorityQueue->head;
	int answer = temp->value;
	priorityQueue->head = temp->next;
	delete temp;
	
	return answer;
}

bool isEmpty(PriorityQueue *priorityQueue)
{
	return priorityQueue->head == nullptr;
}


void deletePriorityQueue(PriorityQueue *&priorityQueue)
{
	Node *temp = priorityQueue->head;

	while (temp != nullptr)
	{
		Node *toDelete = temp;
		temp = temp->next;
		delete toDelete;
	}

	delete priorityQueue;
	priorityQueue = nullptr;
}