//does some hack-y stuff manipulating memory on the stack
//see stack-frame-deallocation.go to see if its possible there
#include <stdio.h>
#include <stdlib.h>

const static int *global;

void a() {
	int y = 13;
}

void f() {
    char y = 'a'; // what if we put something before it?
	int x = 12;
	global = &x; //should x live on?
}

int main () {
	f();
	//function is called and f() stack is now deallocated
	printf("globals value:\t%d\nglobals ptr:\t%p\nglobals\taddress %p\n", *global, global, &global);
	a();
	//now what happens?
	printf("globals value:\t%d\n", *global);
}


