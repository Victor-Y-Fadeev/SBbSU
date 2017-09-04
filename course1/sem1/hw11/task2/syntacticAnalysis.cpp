#include "syntacticAnalysis.h"
#include <string.h>

/*
E -> id F
F -> T id F | '\0'
T -> + | - | / | *
*/

bool ruleT(char *&string)
{
	if ((string[0] == '+') || (string[0] == '-') || (string[0] == '*') || (string[0] == '/'))
	{
		string += 2;
		return true;
	}

	return false;
}

bool ruleE(char *&string);

bool ruleF(char *&string)
{
	if (string[0] == '\0')
		return true;

	if (ruleT(string))
		return ruleE(string);
	else
		return false;
}

bool ruleE(char *&string)
{
	if (strstr(string, "id ") == string)
	{
		string += 3;
		return ruleF(string);
	}
	
	return false;
}

bool parseString(char *string)
{		
	return ruleE(string);
}