#pragma once

struct String;


String *createString(char *string);
String *clone(String *string);

void concatenation(String *original, String *added);
bool isEquality(String *first, String *second);
bool isEmpty(String *string);
bool isSubstring(String *string, String *substring);
int size(String *string);
char *toChar(String *string);

void deleteString(String *&string);