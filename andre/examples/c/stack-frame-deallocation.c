#include <stdio.h>
#include <stdlib.h>

const static int *global;

int a() {

	char *string = malloc(8 * sizeof(char));
	return (int) string;

}


void f() {
	int x = 12;
	global = &x;

}

int main () {

	f();
	
	printf("%d\n", *global);
	a();

	printf("%d\n", *global);


}


