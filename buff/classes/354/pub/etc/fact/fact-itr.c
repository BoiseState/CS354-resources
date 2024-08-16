// gcc -o fact-itr fact-itr.c -g -Wall && ./fact-itr 5

#include <stdio.h>
#include <stdlib.h>

extern int fact(int n) {
  int res=1;
  while (n)
    res*=n--;
  return res;
}

int main(int argc, char *argv[]) {
  int n=argc==2 ? atoi(argv[1]) : 0;
  printf("fact(%d)=%d\n",n,fact(n));
  return 0;
}
