#include <iostream>

using namespace std;

int fibonacciRecursion(int n)
{
	if (n == 0)
		return 0;
	if (n == 1)
		return 1;

	return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
}

void swap(int &x, int &y)
{
	if (x == y)
		return;

	x = x ^ y;
	y = x ^ y;
	x = x ^ y;
}

int fibonacciIteration(int n)
{
	if (n == 0)
		return 0;

	int a = 0;
	int b = 1;

	for (int i = 1; i < n; i++)
	{
		a += b;
		swap(a, b);
	}

	return b;
}

int main()
{
	int n = 0;

	cout << "Enter Fibonacci number: ";
	cin >> n;
	cout << "F(10) = " << fibonacciRecursion(n) << " = " << fibonacciIteration(n) << endl;
	
	return 0;
}