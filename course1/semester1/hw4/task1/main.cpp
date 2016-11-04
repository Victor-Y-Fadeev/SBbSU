#include <iostream>

using namespace std;

void out(int *a[], int n)
{
	int left = (n - 1) / 2;
	int right = left;
	
	int i = left;
	int j = left;
	for (int k = 0; k < n * n; k++)
	{
		cout << a[i][j] << " ";
		if ((j == left) && (i == left))
		{
			right++;
			left--;
			j--;
			continue;
		}
		if ((j == left) && (i < right))
		{
			i++;
			continue;
		}
		if ((j < right) && (i == right))
		{
			j++;
			continue;
		}
		if ((j == right) && (i > left))
		{
			i--;
			continue;
		}
		if ((j > left) && (i == left))
		{
			j--;
			continue;
		}
	}
}

int main()
{
	int n = 0;
	cout << "Enter N: ";
	cin >> n;

	int **values = new int*[n];
	for (int i = 0; i < n; i++)
		values[i] = new int[n];

	cout << "Enter array: ";
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> values[i][j];

	out(values,n);

	for (int i = 0; i < n; i++)
		delete[] values[i];
	delete[] values;
	return 0;
}