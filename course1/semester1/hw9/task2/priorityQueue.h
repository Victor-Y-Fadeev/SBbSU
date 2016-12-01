#pragma once

struct PriorityQueue;

PriorityQueue *createPriorityQueue();

void insert(PriorityQueue *priorityQueue, int key, int value);
int extractMinimum(PriorityQueue *priorityQueue);
bool isEmpty(PriorityQueue *priorityQueue);

void deletePriorityQueue(PriorityQueue *&priorityQueue);