#include <stdio.h>
#include <string.h>

int main()
{
	char haystack[256] = {'\0'};
	char needle[256] = {'\0'};

	printf("Enter Haystack: ");
	scanf("%s", &haystack);
	printf("Enter Needle: ");
	scanf("%s", &needle);
	
	int counter = 0;
	int differenceString = strlen(haystack) - strlen(needle);
	for (int i = 0; i <= differenceString; i++)
	{
		bool isFound = false;
		int j = 0;
		while ((!isFound) && (j < strlen(needle)))
		{
			if (needle[j] != haystack[i + j])
			{
				isFound = true;
			}
			j++;
		}

		if (!isFound)
		{
			counter++;
		}
	}

	printf("Number of entries: %d \n", counter);

	return 0;
}