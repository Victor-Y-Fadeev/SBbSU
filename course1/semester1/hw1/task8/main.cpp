#include <iostream>

int factorialRecursion(int factorial)
{
	if (factorial != 0)
	{
		return factorial * factorialRecursion(factorial - 1);
	}
	else {
		return 1;
	}
}

int factorialIteration(int factorial)
{
	int result = 1;

	for (int i = 2; i <= factorial; i++)
	{
		result *= i;
	}

	return result;
}

void main()
{
	int factorial = 0;

	printf("Enter factorial: ");
	scanf("%d", &factorial);

	int resultRecursion = factorialRecursion(factorial);
	int resultIteration = factorialIteration(factorial);
	printf("%d! = %d = %d \n", factorial, resultRecursion, resultIteration);
}