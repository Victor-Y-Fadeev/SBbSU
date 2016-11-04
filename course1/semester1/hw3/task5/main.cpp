#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

int random()
{
	return rand() * rand() % 1000000001;
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

bool search(int values[], int left, int right, int element)
{
	if (right < left)
		return false;

	if (element == values[(left + right) / 2])
		return true;

	if (element < values[(left + right) / 2])
		return search(values, left, (left + right) / 2 - 1, element);
	else
		return search(values, (left + right) / 2 + 1, right, element);	
}

int main()
{
	srand((unsigned)time(nullptr));

	int n = 0;
	int k = 0;
	cout << "Enter N & K: ";
	cin >> n >> k;

	int *values = new int[n];
	for (int i = 0; i < n; i++)
	{
		values[i] = random();
	}
	
	qSort(values, 0, n - 1);
	
	int found = 0;
	for (int i = 0; i < k; i++)
	{
		found += search(values, 0, n - 1, random());
	}

	cout << found << " elements found" << endl;

	delete[] values;
	return 0;
}