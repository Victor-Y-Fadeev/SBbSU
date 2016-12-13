#include "lexicalAnalysis.h"
#include "finiteStateMachine.h"
#include <string.h>

int const stringSize = 1024;

struct Lexer
{
	Machine *numberRule;
	Machine *plusRule;
	Machine *minusRule;
	Machine *multiplyRule;
	Machine *divideRule;
};


Lexer *createLexer()
{
	Lexer *newLexer = new Lexer;

	newLexer->numberRule = loadMachine("numberTable.txt");
	newLexer->plusRule = loadMachine("plusTable.txt");
	newLexer->minusRule = loadMachine("minusTable.txt");
	newLexer->multiplyRule = loadMachine("multiplyTable.txt");
	newLexer->divideRule = loadMachine("divideTable.txt");

	return newLexer;
}

char *cleaningFromSpace(char *string)
{
	char *answer = new char[stringSize];

	int i = 0;
	int j = 0;
	while (string[i] != '\0')
	{
		if ((string[i] != ' ') && (string[i] != '	'))
		{
			answer[j] = string[i];
			j++;
		}
		i++;
	}

	answer[j] = '\0';
	return answer;
}

char *analyzeString(Lexer *lexer, char *string)
{
	char *testingString = cleaningFromSpace(string);
	char *answer = new char[stringSize];
	answer[0] = '\0';

	char *temp = testingString;
	while (temp[0] != '\0')
	{
		if (testString(lexer->numberRule, temp))
			strcat(answer, "id");
		else if (testString(lexer->plusRule, temp))
			strcat(answer, " + ");
		else if (testString(lexer->minusRule, temp))
			strcat(answer, " - ");
		else if (testString(lexer->multiplyRule, temp))
			strcat(answer, " * ");
		else if (testString(lexer->divideRule, temp))
			strcat(answer, " / ");
		else
		{
			strcpy(answer, "Lexical error!");
			delete[] testingString;
			return answer;
		}
	}

	delete[] testingString;
	return answer;
}

void deleteLexer(Lexer *&lexer)
{
	deleteMachine(lexer->numberRule);
	deleteMachine(lexer->plusRule);
	deleteMachine(lexer->minusRule);
	deleteMachine(lexer->multiplyRule);
	deleteMachine(lexer->divideRule);

	delete lexer;
	lexer = nullptr;
}