// gcc -o fact-rec fact-rec.c -g -Wall && ./fact-rec 5

#include <stdio.h>
#include <stdlib.h>

extern int fact(int n) {
  if (n==0) return 1;
  if (n==1) return 1;
  return n*fact(n-1);
}

int main(int argc, char *argv[]) {
  int n=argc==2 ? atoi(argv[1]) : 0;
  printf("fact(%d)=%d\n",n,fact(n));
  return 0;
}
