#include <iostream>
#include "expressionTree.h"

using namespace std;

int main()
{
	ExpressionTree *tree = createExpressionTree();

	loadExpression(tree, "expression.txt");
	
	char *temp = outputExpression(tree);
	cout << "Expression: " << temp << endl;
	delete[] temp;
	cout << "Result: " << count(tree) << endl;

	deleteExpressionTree(tree);
	return 0;
}