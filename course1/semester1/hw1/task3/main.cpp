#include <stdio.h>

void reverse(int *mas, int begin, int size)
{
	int condition = begin + size / 2;
	int end = 2 * begin + size - 1;

	for (int i = begin; i < condition; i++)
	{
		mas[i] = mas[i] ^ mas[end - i];
		mas[end - i] = mas[i] ^ mas[end - i];
		mas[i] = mas[i] ^ mas[end - i];
	}
}

int main()
{
	int m = 0;
	int n = 0;

	printf("Enter M & N: ");
	scanf("%d %d", &m, &n);

	int *mas = new int[m + n];

	printf("Enter array: ");
	for (int i = 0; i < m + n; i++)
	{
		scanf("%d", &mas[i]);
	}

	reverse(mas, 0, m);
	reverse(mas, m, n);
	reverse(mas, 0, m + n);

	printf("Sorted array: ");
	for (int i = 0; i < m + n; i++)
	{
		printf("%d ", mas[i]);
	}

	delete [] mas;
	printf("\n");
	return 0;
}