#include "aStar.h"
#include <fstream>
#include <complex>
#include <string.h>
#include "priorityQueue.h"

using namespace std;

int const stringSize = 256;

struct Map
{
	int **matrix;
	int sizeN;
	int sizeM;
	PriorityQueue *forConsideration;
	bool *considered;
	int *dist;
	int *way;
};


int **createMatrix(int sizeN, int sizeM)
{
	int **newMatrix = new int*[sizeN];

	for (int i = 0; i < sizeN; i++)
		newMatrix[i] = new int[sizeM];

	return newMatrix;
}

Map *createMap(int sizeN, int sizeM)
{
	Map *newMap = new Map;

	newMap->matrix = createMatrix(sizeN, sizeM);
	newMap->sizeN = sizeN;
	newMap->sizeM = sizeM;
	newMap->forConsideration = nullptr;
	newMap->considered = nullptr;
	newMap->dist = nullptr;
	newMap->way = nullptr;

	return newMap;
}

Map *loadMap(char *path)
{
	fstream file;
	file.open(path, ios::in);
	
	int sizeN;
	file >> sizeN;
	int sizeM;
	file >> sizeM;

	Map *map = createMap(sizeN, sizeM);

	for (int i = 0; i < sizeN; i++)
		for (int j = 0; j < sizeM; j++)
			file >> map->matrix[i][j];

	file.close();
	return map;
}


void addNumber(char *string, int number)
{
	char *temp = new char[stringSize];

	sprintf(temp, "%d", number);
	strcat(string, temp);
	delete[] temp;

	strcat(string, " ");
}

char *output(Map *map)
{
	char *answer = new char[stringSize];
	strcpy(answer, "0 - free, 1 - blocks, 2 - way\n\n");

	for (int i = 0; i < map->sizeN; i++)
	{
		strcat(answer, "    ");
		
		for (int j = 0; j < map->sizeM; j++)
			addNumber(answer, map->matrix[i][j]);
		
		strcat(answer, "\n");
	}

	return answer;
}

int heuristicFunction(Map *map, int current, int goal)
{
	return sqrt(pow(current % map->sizeM - goal % map->sizeM, 2) + pow(current / map->sizeM - goal / map->sizeM, 2));
}

void createSupportElements(Map *map)
{
	map->forConsideration = createPriorityQueue();
	
	int size = map->sizeN * map->sizeM;
	map->considered = new bool[size];
	map->dist = new int[size];
	map->way = new int[size];
	
	for (int i = 0; i < size; i++)
	{
		map->considered[i] = false;
		map->dist[i] = -1;
		map->way[i] = -1;
	}
}

void deleteSupportElements(Map *map)
{
	delete[] map->considered;
	delete[] map->dist;
	delete[] map->way;
	map->considered = nullptr;
	map->dist = nullptr;
	map->way = nullptr;

	deletePriorityQueue(map->forConsideration);
}

void startSettings(Map *map, int current, int goal)
{
	map->considered[current] = true;
	map->dist[current] = 0;
	map->way[current] = current;
	insert(map->forConsideration, heuristicFunction(map, current, goal), current);
}

void processingOfTop(Map *map, int current, int goal, int top)
{
	int dist = map->dist[current] + 1;

	if ((map->considered[top] == true) && (map->dist[top] <= dist))
		return;
	
	if ((map->considered[top] == false) || (map->dist[top] > dist))
	{
		map->way[top] = current;
		map->dist[top] = dist;
		insert(map->forConsideration, heuristicFunction(map, top, goal), top);
	}
}

void processingOfAdjacent(Map *map, int current, int goal)
{
	int currentX = current % map->sizeM;
	int currentY = current / map->sizeM;
	
	if ((currentX + 1 < map->sizeM) && (map->matrix[currentY][currentX + 1] != 1))
		processingOfTop(map, current, goal, current + 1);
	
	if ((currentX - 1 > 0) && (map->matrix[currentY][currentX - 1] != 1))
		processingOfTop(map, current, goal, current - 1);
	
	if ((currentY + 1 < map->sizeN) && (map->matrix[currentY + 1][currentX] != 1))
		processingOfTop(map, current, goal, current + map->sizeM);

	if ((currentY - 1 > 0) && (map->matrix[currentY - 1][currentX] != 1))
		processingOfTop(map, current, goal, current - map->sizeM);
}

void recordWay(Map *map, int current)
{
	map->matrix[current / map->sizeM][current % map->sizeM] = 2;

	while (map->way[current] != current)
	{
		current = map->way[current];
		map->matrix[current / map->sizeM][current % map->sizeM] = 2;
	}
}

void performAStar(Map *map, int startX, int startY, int finishX, int finishY)
{
	createSupportElements(map);
	int current = startY * map->sizeM + startX;
	int goal = finishY * map->sizeM + finishX;
	startSettings(map, current, goal);

	bool finish = false;
	while (!isEmpty(map->forConsideration))
	{
		current = extractMinimum(map->forConsideration);
		if (current == goal)
		{
			finish = true;
			break;
		}
		map->considered[current] = true;
		processingOfAdjacent(map, current, goal);
	}
	
	if (finish == true)
		recordWay(map, current);

	deleteSupportElements(map);
}


void deleteMatrix(int **&matrix, int sizeN)
{
	for (int i = 0; i < sizeN; i++)
		delete[] matrix[i];
	
	delete[] matrix;
	matrix = nullptr;
}

void deleteMap(Map *&map)
{
	deleteMatrix(map->matrix, map->sizeN);

	delete[] map;
	map = nullptr;
}