#include <iostream>
#include <fstream>
#include <limits.h>

using namespace std;

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

void deleteMatrix(int **&matrix, int size)
{
	for (int i = 0; i < size; i++)
		delete[] matrix[i];

	delete[] matrix;
	matrix = nullptr;
}

int **loadMatrix(char *path, int &size)
{
	fstream file;
	file.open(path, ios::in);
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
	return matrix;
}

void createSupportArray(int *&length, int *&way, int size)
{
	length = new int[size];

	length[0] = 0;
	for (int i = 1; i < size; i++)
		length[i] = INT_MAX;

	way = new int[size];
	way[0] = 0;
}

void deleteSupportArray(int *&length, int *&way, int size)
{
	delete[] length;
	length = nullptr;
	delete[] way;
	way = nullptr;
}

void dijkstra(int **matrix, int size, int *&length, int *&way)
{	
	createSupportArray(length, way, size);

	bool *flag = new bool[size];
	for (int i = 0; i < size; i++)
		flag[i] = false;

	int min = 0;
	while (min < size)
	{
		flag[min] = true;
		for (int i = 0; i < size; i++)
		{
			int len = matrix[min][i];
			if ((len != 0) && (length[i] > length[min] + len))
			{
				length[i] = length[min] + len;
				way[i] = min;
			}
		}

		while ((min < size) && !((flag[min] == false) && (length[min] != INT_MAX)))
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

int *createTopsSequence(int *length, int size)
{
	int *tops = new int[size];
	for (int i = 0; i < size; i++)
		tops[i] = i;

	for (int i = 1; i < size; i++)
	{
		int j = i;
		while ((j > 0) && (length[j - 1] > length[j]))
		{
			swap(length[j - 1], length[j]);
			swap(tops[j - 1], tops[j]);
			j--;
		}
	}

	return tops;
}

void output(int *length, int *way, int size)
{
	cout << "City		Length		Way" << endl << endl;
	cout << "1		0		1" << endl;

	int *tops = createTopsSequence(length, size);

	for (int i = 1; i < size; i++)
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

	delete[] tops;
}

int main()
{
	int size = 0;
	int **matrix = loadMatrix("cities.txt", size);

	int *length = nullptr;
	int *way = nullptr;
	dijkstra(matrix, size, length, way);

	output(length, way, size);

	deleteSupportArray(length, way, size);
	deleteMatrix(matrix, size);
	return 0;
}