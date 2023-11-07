// gcc -o incasg incasg.c -g -Wall && ./incasg
// objdump -dS ./incasg

#include <stdio.h>

int main() {
  int i=0;
  i=i++;
  printf("%d\n",i);
}
