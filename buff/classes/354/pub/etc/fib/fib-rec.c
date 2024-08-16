// gcc -o fib-rec fib-rec.c -g -Wall && ./fib-rec 10

#include <stdio.h>
#include <stdlib.h>

extern int fib(int n) {
  if (n==0) return 0;
  if (n==1) return 1;
  if (n==2) return 1;
  return fib(n-1)+fib(n-2);
}

int main(int argc, char *argv[]) {
  int n=argc==2 ? atoi(argv[1]) : 0;
  printf("fib(%d)=%d\n",n,fib(n));
  return 0;
}
