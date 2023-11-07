//gcc -O0 register.c -o register

#include <stdio.h>
#include <stdlib.h>


int main() {
    	register void *sp asm ("sp");
    	printf("%p\n", sp);
    	register void *fp asm ("fp");
    	printf("%p\n", fp);

    	return 0;
}
