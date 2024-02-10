#include <stdio.h>
#include <unistd.h>

void recurse(int n) {
    printf("Location of n is %p\n", &n);
    sleep(1);
    recurse(n);
}

int main() {
    recurse(0);

    return 0;
}