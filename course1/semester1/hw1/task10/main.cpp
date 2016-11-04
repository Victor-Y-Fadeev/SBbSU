#include <stdio.h>
#include <string.h>

int main()
{
	char string[256] = {'\0'};

	printf("Enter string: ");
	scanf("%s", &string);
	
	int stringMiddle = strlen(string) / 2;
	bool isPalindrome = false;
	for (int i = 0; i < stringMiddle; i++)
	{
		if (string[i] != string[strlen(string) - 1 - i])
		{
			isPalindrome = true;
		}
	}

	if (!isPalindrome)
	{
		printf("This is a palindrome \n");
	}
	else
	{
		printf("All bad \n");
	}

	return 0;
}