#include <stdio.h>

// bad C string copy

void strcpy(char *dest, char *src) {

    while (*dest++=*src++);
}

int main(void) {

    char *string = "this is my string";
    char dest[50];

    strcpy(dest, string);

    printf("dest string is now:\n%s\n", dest);

    return 0;
}