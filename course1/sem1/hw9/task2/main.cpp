#include <iostream>
#include "aStar.h"

using namespace std;

bool performAStar(Map *map)
{
	int startX = 0;
	int startY = 0;
	int finishX = 0;
	int finishY = 0;
	
	cout << "//First coordinates (1, 1)" << endl;
	cout << "Enter start coordinates (x, y): ";
	cin >> startX >> startY;
	cout << "Enter finish coordinates (x, y): ";
	cin >> finishX >> finishY;
	cout << endl;

	return performAStar(map, startX - 1, startY - 1, finishX - 1, finishY - 1);
}

int main()
{
	Map *map = loadMap("map.txt");
	
	if (performAStar(map))
	{
		char *temp = output(map);
		cout << temp << endl;
		delete[] temp;
	}
	else
		cout << "No Way!" << endl;

	deleteMap(map);
	return 0;
}