//Credit dragon book pg 32
//try gcc -E dynamic-scope.c -o dynamic-scope.c
//then try doing that again with #include <stdio.h>
#include <stdio.h>
#define a (x + 1) // what does this x refer too? It depends...

int printf(const char * restrict, ...);

int x = 2;

void b() { int x = 1; printf("%d\n", a); }
void c() { printf("%d\n", a); }

int main() { b(); c(); }