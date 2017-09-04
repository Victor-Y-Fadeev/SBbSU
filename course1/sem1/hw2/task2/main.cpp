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

void qSort(int values[], int left, int right)
{
	int i = left;
	int j = right;

	int pivot = values[(i + j) / 2];

	while (i <= j)
	{
		while (values[i] < pivot)
			i++;
		while (values[j] > pivot)
			j--;

		if ((values[i] >= values[j]) && (i <= j))
		{
			swap(values[i], values[j]);
			i++;
			j--;
		}
	}

	if (i < right)
		qSort(values, i, right);

	if (j > left)
		qSort(values, left, j);
}

int main()
{
	const int size = 5;
	int values[size] = {0};

	inputArray(values, size);
	qSort(values, 0, size - 1);
	outputArray(values, size);

	return 0;
}