CC=g++
CFLAGS=-c -Wall -std=c++11
LDFLAGS=
SOURCES=huffman.cpp main.cpp tree.cpp
OBJECTS=$(SOURCES:.cpp=.o)
EXECUTABLE=main.out

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS) 
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

.cpp.o:
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -rf *.o $(EXECUTABLE)
