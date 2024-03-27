//does some hack-y stuff manipulating memory on the stack
//see stack-frame-deallocation.go to see if its possible there
#include <stdio.h>
#include <stdlib.h>

const static int *global;

void a() {

	int y = 13;

}


void f() {
	int x = 12;
	global = &x; //should x live on?

}

int main () {

	f();
	//function is called and f() stack is now deallocated
	printf("globals value:\t%d\nglobals ptr:\t%p\nglobals\taddress %p\n", *global, global, &global);
	a();
	//same stack space reused!
	printf("globals value:\t%d\n", *global);


}


