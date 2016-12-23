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
	Machine *spaceRule;
};


Lexer *createLexer()
{
	Lexer *newLexer = new Lexer;

	newLexer->numberRule = loadMachine("numberTable.txt");
	newLexer->plusRule = loadMachine("plusTable.txt");
	newLexer->minusRule = loadMachine("minusTable.txt");
	newLexer->multiplyRule = loadMachine("multiplyTable.txt");
	newLexer->divideRule = loadMachine("divideTable.txt");
	newLexer->spaceRule = loadMachine("spaceTable.txt");

	return newLexer;
}

char *analyzeString(Lexer *lexer, char *string)
{
	char *answer = new char[stringSize];
	answer[0] = '\0';

	char *temp = string;
	while (temp[0] != '\0')
	{
		if (testString(lexer->numberRule, temp))
			strcat(answer, "id ");
		else if (testString(lexer->plusRule, temp))
			strcat(answer, "+ ");
		else if (testString(lexer->minusRule, temp))
			strcat(answer, "- ");
		else if (testString(lexer->multiplyRule, temp))
			strcat(answer, "* ");
		else if (testString(lexer->divideRule, temp))
			strcat(answer, "/ ");
		else if (!testString(lexer->spaceRule, temp))
		{
			strcpy(answer, "");
			return answer;
		}
	}

	return answer;
}

void deleteLexer(Lexer *&lexer)
{
	deleteMachine(lexer->numberRule);
	deleteMachine(lexer->plusRule);
	deleteMachine(lexer->minusRule);
	deleteMachine(lexer->multiplyRule);
	deleteMachine(lexer->divideRule);
	deleteMachine(lexer->spaceRule);

	delete lexer;
	lexer = nullptr;
}