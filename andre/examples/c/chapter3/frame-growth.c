#include <stdio.h>
#include <unistd.h>

void recurse(int n, int *addr) {
    printf("Location of n is %p\n", &n);
    printf("num bytes since last call 0x%lx\n", (addr - &n));
    sleep(1);
    recurse(n, &n);
}

int main() {
    int n = 0;
    recurse(n, &n);

    return 0;
}