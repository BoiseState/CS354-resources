
CC = gcc
CFLAGS = -Wall -Wextra -Wpointer-arith -Wstrict-prototypes -std=c99 -g

.PHONY: build test clean

build: SimpleTest

SimpleTest: SimpleTest.o SinglyLinkedList.o Job.o
	$(CC) $(CFLAGS) $^ -o $@ 

test:
	./SimpleTest

clean:
	rm -f *.o *.d a.out SimpleTest
