#include <iostream>
#include "aStar.h"

using namespace std;

void performAStar(Map *map)
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

	performAStar(map, startX - 1, startY - 1, finishX - 1, finishY - 1);
}

int main()
{
	Map *map = loadMap("map.txt");
	
	performAStar(map);
	
	char *temp = output(map);
	cout << temp << endl;
	delete[] temp;

	deleteMap(map);
	return 0;
}