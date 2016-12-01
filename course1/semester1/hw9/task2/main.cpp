#include <iostream>
#include "aStar.h"

using namespace std;

int main()
{
	Map *map = loadMap("map.txt");
		
	aStar(map, 0, 0, 5, 5);

	char *temp = output(map);
	cout << temp << endl;
	delete[] temp;

	deleteMap(map);
	return 0;
}