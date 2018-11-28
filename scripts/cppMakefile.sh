#!/bin/bash

num=$1
files=`ls -xm *.cpp`
main=`grep -rl " main(" .`
main=${main%".cpp"}

cat << EOF > Makefile
CC=g++
CFLAGS=-c -Wall -std=c++11
LDFLAGS=
SOURCES=${files//","/""}
OBJECTS=\$(SOURCES:.cpp=.o)
EXECUTABLE=${main#"./"}.out

all: \$(SOURCES) \$(EXECUTABLE)

\$(EXECUTABLE): \$(OBJECTS) 
	\$(CC) \$(LDFLAGS) \$(OBJECTS) -o \$@

.cpp.o:
	\$(CC) \$(CFLAGS) \$< -o \$@

clean:
	rm -rf *.o \$(EXECUTABLE)
EOF

echo "Task $num: Makefile generated..."

if ! make >/dev/null 2>/dev/null ; then
	make
	exit 1;
fi

make -f Makefile clean >/dev/null 2>/dev/null

exit 0
