#include <iostream>

void main()
{
	int x = 0;

	printf("Enter X: ");
	scanf("%d", &x);

	int x2 = x * x;
	int result = (x2 + x) * (x2 + 1) + 1;
	printf("x^4 + x^3 + x^2 + x + 1 = %d \n", result);
}