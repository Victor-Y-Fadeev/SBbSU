#include <stdio.h>

int main()
{
	int a = 0;
	int n = 0;

	printf("Enter A^n: ");
	scanf("%d %d", &a, &n);
	
	int answer = 1;
	while (n > 0)
	{
		if (n % 2 == 0)
		{
			a *= a;
			n /= 2;
		}
		else
		{
			answer *= a;
			n--;
		}
	}

	printf("Power = %d \n", answer);
	return 0;
}