#include <fstream>
#include <limits.h>
#include "dijkstra.h"

using namespace std;

struct Graph
{
	int **matrix;
	int *length;
	int *way;
	int size;
};


Graph *createGraph(int **matrix, int size)
{
	Graph *newGraph = new Graph;
	newGraph->matrix = matrix;
	newGraph->size = size;
	newGraph->length = nullptr;
	newGraph->way = nullptr;
	return newGraph;
}

int **createMatrix(int size)
{
	int **matrix = new int*[size];

	for (int i = 0; i < size; i++)
		matrix[i] = new int[size];

	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			matrix[i][j] = 0;

	return matrix;
}

Graph *loadGraph(char *path)
{
	fstream file;
	file.open(path, ios::in);

	int size = 0;
	file >> size;

	int **matrix = createMatrix(size);

	int m = 0;
	file >> m;
	for (int i = 0; i < m; i++)
	{
		int a = 0;
		file >> a;
		int b = 0;
		file >> b;
		int len = 0;
		file >> len;
		matrix[a - 1][b - 1] = len;
		matrix[b - 1][a - 1] = len;
	}

	file.close();

	return createGraph(matrix, size);
}


void createSupportArray(Graph *graph)
{
	graph->length = new int[graph->size];

	graph->length[0] = 0;
	for (int i = 1; i < graph->size; i++)
		graph->length[i] = INT_MAX;

	graph->way = new int[graph->size];
	graph->way[0] = 0;
}

void dijkstra(Graph *graph)
{
	createSupportArray(graph);

	bool *flag = new bool[graph->size];
	for (int i = 0; i < graph->size; i++)
		flag[i] = false;

	int min = 0;
	while (min < graph->size)
	{
		flag[min] = true;
		for (int i = 0; i < graph->size; i++)
		{
			int len = graph->matrix[min][i];
			if ((len != 0) && (graph->length[i] > graph->length[min] + len))
			{
				graph->length[i] = graph->length[min] + len;
				graph->way[i] = min;
			}
		}

		while ((min < graph->size) && !((flag[min] == false) && (graph->length[min] != INT_MAX)))
			min++;
	}

	delete[] flag;
}

void swap(int &x, int &y)
{
	if (x == y)
		return;

	x = x ^ y;
	y = x ^ y;
	x = x ^ y;
}

void sortTopsSequence(Graph *graph, int *&length, int *&tops)
{
	tops = new int[graph->size];
	length = new int[graph->size];

	for (int i = 0; i < graph->size; i++)
	{
		tops[i] = i;
		length[i] = graph->length[i];
	}

	for (int i = 1; i < graph->size; i++)
	{
		int j = i;
		while ((j > 0) && (length[j - 1] > length[j]))
		{
			swap(length[j - 1], length[j]);
			swap(tops[j - 1], tops[j]);
			j--;
		}
	}
}

int *returnWay(Graph *graph)
{
	int *way = new int[graph->size];

	for (int i = 0; i < graph->size; i++)
		way[i] = graph->way[i];
	
	return way;
}

int size(Graph *graph)
{
	return graph->size;
}


void deleteMatrix(int **&matrix, int size)
{
	for (int i = 0; i < size; i++)
		delete[] matrix[i];

	delete[] matrix;
	matrix = nullptr;
}

void deleteSupportArray(Graph *graph)
{
	delete[] graph->length;
	graph->length = nullptr;
	delete[] graph->way;
	graph->way = nullptr;
}

void deleteGraph(Graph *&graph)
{
	deleteSupportArray(graph);
	deleteMatrix(graph->matrix, graph->size);

	delete graph;
	graph = nullptr;
}