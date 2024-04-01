#include <stdio.h>

int access(int *arr) {

    printf("%d\n", arr[3]);
    printf("%d\n", arr[-1]); // :(
    return 0;
}

int main() {

    int arr[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    access(arr);
    access(&arr[3]);
    access(arr + 3);

    printf("addr of arr: %p\n", arr);
    printf("addr of &arr[3]: %p\n", &arr[3]);
    printf("addr of arr + 3: %p\n", arr + 3);
    printf("addr of arr + 3: %p\n", &arr[3] - 2);

    return 0;
}