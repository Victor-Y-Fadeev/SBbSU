#include <iostream>
#include "aStar.h"

using namespace std;

int main()
{
	Map *map = loadMap("map.txt");
		
	char *temp = output(map);
	cout << temp << endl;
	delete[] temp;

	deleteMap(map);
	return 0;
}