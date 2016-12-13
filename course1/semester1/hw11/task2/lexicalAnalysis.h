#pragma once

struct Lexer;


Lexer *createLexer();

char *analyzeString(Lexer *lexer, char *string);

void deleteLexer(Lexer *&lexer);