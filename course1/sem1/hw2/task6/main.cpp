#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

const int numberLevel = 4;

bool isRepeat(int mas[], int size, int number)
{
	bool answer = false;
	
	for (int i = 0; i < size; i++)
		if (mas[i] == number)
			answer = true;
	
	return answer;
}

int number()
{
	int mas[numberLevel] = {0};
	mas[0] = 1 + rand() % 9;
	
	for (int i = 1; i < numberLevel; i++)
	{
		mas[i] = rand() % 10;

		while (isRepeat(mas, i, mas[i]))
			mas[i] = rand() % 10;		
	}

	int answer = mas[0];
	for (int i = 1; i < numberLevel; i++)
		answer = answer * 10 + mas[i];

	return answer;
}

void compare(int puzzle, int attempt)
{
	int puzzleArray[numberLevel] = {0};
	int attemptArray[numberLevel] = {0};
	int bulls = 0;
	int	cow = 0;

	for (int i = 0; i < numberLevel; i++)
	{
		puzzleArray[i] = puzzle % 10;
		puzzle /= 10;
		attemptArray[i] = attempt % 10;
		attempt /= 10;
		if (puzzleArray[i] == attemptArray[i])
			bulls++;
	}

	for (int i = 0; i < numberLevel; i++)
		for (int j = 0; j < numberLevel; j++)
			if (puzzleArray[i] == attemptArray[j])
				cow++;

	cow -= bulls;

	cout << "Bulls (" << bulls << "), cow(" << cow << ")" << endl << endl;
}

int main()
{	
	srand((unsigned)time(nullptr));

	int puzzle = number();
	cout << "I has thought the number, Guess: ";
	
	int attempt = 0;
	cin >> attempt;

	while (puzzle != attempt)
	{
		compare(puzzle, attempt);
		cout << "Try again: ";
		cin >> attempt;
	}
	cout << "Right!" << endl;
	
	return 0;
}