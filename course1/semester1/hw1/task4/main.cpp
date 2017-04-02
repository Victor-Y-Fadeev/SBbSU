#include <iostream>

int main()
{
	int mas[28] = {0};
	
	for (int i = 0; i < 10; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			for (int k = 0; k < 10; k++)
			{
				mas[i + j + k]++;
			}
		}
	}
	
	int result = 0;
	for (int i = 0; i < 28; i++)
	{
		result += mas[i] * mas[i];
	}
	printf("Happy ticket: %d \n", result);
}
