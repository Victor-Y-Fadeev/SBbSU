#pragma once

struct ExpressionTree;


ExpressionTree *createExpressionTree();
void loadExpression(ExpressionTree *tree, char *path);

char *outputExpression(ExpressionTree *tree);
int count(ExpressionTree *tree);

void deleteExpressionTree(ExpressionTree *&tree);