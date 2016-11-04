#include <stdio.h>

int main()
{
	int number = 0;

	printf("Enter number: ");
	scanf("%d", &number);
	
	bool *sieve = new bool[number + 1];
	for (int i = 0; i <= number; i++)
	{
		sieve[i] = false;
	}

	for (int i = 2; i <= number; i++)
	{
		int j = i * 2;
		while (j <= number)
		{
			sieve[j] = true;
			j += i;
		}
	}

	printf("Prime numbers: ");
	for (int i = 2; i <= number; i++)
	{
		if (!sieve[i])
		{
			printf("%d ", i);
		}
	}

	delete [] sieve;
	printf("\n");
	return 0;
}