#include <iostream>
#include <fstream>

using namespace std;

int **createMap(int sizeN, int sizeM)
{
	int **map = new int*[sizeN];

	for (int i = 0; i < sizeN; i++)
		map[i] = new int[sizeM];

	return map;
}

void deleteMap(int **&map, int sizeN)
{
	for (int i = 0; i < sizeN; i++)
		delete[] map[i];

	delete[] map;
	map = nullptr;
}

int **loadMap(char *path, int &sizeN, int &sizeM)
{
	fstream file;
	file.open(path, ios::in);
	file >> sizeN;
	file >> sizeM;

	int **map = createMap(sizeN, sizeM);
	for (int i = 0; i < sizeN; i++)
		for (int j = 0; j < sizeM; j++)
			file >> map[i][j];

	file.close();
	return map;
}

void output(int **map, int sizeN, int sizeM)
{
	cout << "0 - free, 1 - blocks, 2 - way" << endl << endl;

	for (int i = 0; i < sizeN; i++)
	{
		cout << "    ";
		for (int j = 0; j < sizeM; j++)
			cout << map[i][j] << " ";
		cout << endl;
	}
}

int main()
{
	int sizeN = 0;
	int sizeM = 0;
	int **map = loadMap("map.txt", sizeN, sizeM);
		
	output(map, sizeN, sizeM);

	deleteMap(map, sizeN);
	return 0;
}