#pragma once

struct PriorityQueue;

PriorityQueue *createPriorityQueue();

void insert(PriorityQueue *priorityQueue, int key, int value);
int extractMinimum(PriorityQueue *priorityQueue);
void update(PriorityQueue *priorityQueue, int key, int value);
bool isEmpty(PriorityQueue *priorityQueue);

void deletePriorityQueue(PriorityQueue *&priorityQueue);