#include <stdio.h>

/*
Compile with gcc -g
GDB:
    break c
    run
    backtrace
    frame 2
    print $sp
    print $fp
*/

static int x = 2;

void c() {

    char *string = "Hello everyone!";
	printf("c() string constant: %p\n", string);
}

void b() {

	register void *sp asm ("sp");
	printf("b() stack pointer: %p\n", sp);
	c();
}

void a() {

	register void *sp asm ("sp");
	printf("a() stack pointer: %p\n", sp);
	b();
}

int main() {

	printf("static variable location: %p\n", &x);
	a();
}
