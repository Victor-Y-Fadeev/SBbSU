#include <iostream>

using namespace std;

void inputArray(int values[], int size)
{
	cout << "Input array of " << size << " elements: ";

	for (int i = 0; i < size; i++)
		cin >> values[i];
}

void outputArray(int values[], int size)
{
	cout << "Array: ";

	for (int i = 0; i < size; i++)
		cout << values[i] << " ";

	cout << endl;
}

void swap(int &x, int &y)
{
	if (x == y)
		return;

	x = x ^ y;
	y = x ^ y;
	x = x ^ y;
}

void sort(int values[], int size)
{
	if (size == 1)
		return;


	for (int i = size / 2 - 1; i >= 0; i--)
	{
		int	largeChild = 2 * i + 1;

		if ((2 * i + 2 < size) && (values[largeChild] < values[2 * i + 2]))
			largeChild = 2 * i + 2;
		if (values[i] < values[largeChild])
			swap(values[i], values[largeChild]);
	}

	swap(values[0], values[size - 1]);
	sort(values, size - 1);
}

int main()
{
	const int size = 5;
	int values[size] = {0};

	inputArray(values, size);
	sort(values, size);
	outputArray(values, size);
	
	return 0;
}