CC=g++
CFLAGS=-c -Wall
LDFLAGS=
SOURCES=finiteStateMachine.cpp lexicalAnalysis.cpp main.cpp syntacticAnalysis.cpp
OBJECTS=$(SOURCES:.cpp=.o)
EXECUTABLE=main.out

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS) 
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

.cpp.o:
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -rf *.o $(EXECUTABLE)
