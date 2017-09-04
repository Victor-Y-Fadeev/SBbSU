#pragma once

struct Machine;

Machine *loadMachine(char *path);

bool testString(Machine *machine, char *&string);

void deleteMachine(Machine *&machine);