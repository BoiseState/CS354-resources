#include <stdio.h>
#include <stdlib.h>

// dangling references to the heap in C
int main() {
    int *i = (int *) malloc(sizeof(int));
    *i = 123;
    free(i);
    *i = 321; //can I use this again?
    int *j = (int *) malloc(sizeof(int));
    *j = 777;
    printf("%d\n",*i);
    return 0;
}