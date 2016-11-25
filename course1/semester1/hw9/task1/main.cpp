#include <iostream>
#include <fstream>
#include <limits.h>

using namespace std;

int **loadMatrix(char *path, int &size)
{
	fstream file;
	file.open(path, ios::in);
	file >> size;

	int **matrix = new int*[size];
	for (int i = 0; i < size; i++)
		matrix[i] = new int[size];

	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			matrix[i][j] = INT_MAX;

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
	return matrix;
}

int main()
{
	int size = 0;
	int **matrix = loadMatrix("cities.txt", size);

	return 0;
}