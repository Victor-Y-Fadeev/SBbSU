#include <iostream>

void main()
{
	int a = 0;
	int b = 0;

	printf("Enter A & B: ");
	scanf("%d %d", &a, &b);

	bool mark = 0;
	if (a * b < 0)
	{
		mark = 1;
	}

	a = abs(a);
	b = abs(b);
	int quotient = 0;
	while (a >= b)
	{
		a -= b;
		quotient++;
	}

	if (!mark)
	{
		printf("a / b = %d \n", quotient);
	}
	else {
		printf("a / b = -%d \n", quotient);
	}
}