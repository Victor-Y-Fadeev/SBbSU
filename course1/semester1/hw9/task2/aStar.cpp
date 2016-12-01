#include "aStar.h"
#include <fstream>
#include <string.h>

using namespace std;

int const stringSize = 256;

struct Map
{
	int **matrix;
	int sizeN;
	int sizeM;
};


Map *createMap(int sizeN, int sizeM)
{
	Map *newMap = new Map;

	newMap->matrix = new int*[sizeN];
	newMap->sizeN = sizeN;
	newMap->sizeM = sizeM;

	for (int i = 0; i < sizeN; i++)
		newMap->matrix[i] = new int[sizeM];

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

void aStar(Map *map, int startX, int startY, int finishX, int finishY)
{

}


void deleteMap(Map *&map)
{
	for (int i = 0; i < map->sizeN; i++)
		delete[] map->matrix[i];

	delete[] map;
	map = nullptr;
}