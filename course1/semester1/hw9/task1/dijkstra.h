#pragma once

struct Graph;

Graph *loadGraph(char *path);

void dijkstra(Graph *graph);
void sortTopsSequence(Graph *graph, int *&length, int *&tops);
int *returnWay(Graph *graph);
int size(Graph *graph);

void deleteGraph(Graph *&graph);