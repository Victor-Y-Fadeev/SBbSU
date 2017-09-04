#include <iostream>
#include <limits.h>
#include "dijkstra.h"

using namespace std;

void output(Graph *graph)
{
	cout << "City		Length		Way" << endl << endl;
	cout << "1		0		1" << endl;

	int *way = returnWay(graph);
	int *length = nullptr;
	int *tops = nullptr;
	sortTopsSequence(graph, length, tops);

	for (int i = 1; i < size(graph); i++)
	{
		if (length[i] == INT_MAX)
			continue;

		cout << tops[i] + 1 << "		" << length[i] << "		" << tops[i] + 1;
		int j = tops[i];
		while (way[j] != 0)
		{
			j = way[j];
			cout << " <- " << j + 1;
		}
		cout << " <- 1" << endl;
	}

	delete[] way;
	delete[] length;
	delete[] tops;
}

int main()
{
	Graph *graph= loadGraph("cities.txt");

	dijkstra(graph);
	output(graph);

	deleteGraph(graph);
	return 0;
}
