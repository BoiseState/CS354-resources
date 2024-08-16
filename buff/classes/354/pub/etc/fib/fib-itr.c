// gcc -o fib-itr fib-itr.c -g -Wall && ./fib-itr 10

#include <stdio.h>
#include <stdlib.h>

extern int fib(int n) {
  int i=0, j=1;
  while (n--) {
    int t=i;
    i=j;
    j+=t;
  }
  return i;
}

int main(int argc, char *argv[]) {
  int n=argc==2 ? atoi(argv[1]) : 0;
  printf("fib(%d)=%d\n",n,fib(n));
  return 0;
}
