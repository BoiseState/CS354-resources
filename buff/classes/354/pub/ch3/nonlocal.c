// gcc -Wall -g -o nonlocal nonlocal.c && ./nonlocal

// NATO: alfa bravo charlie delta echo

#include <stdio.h>

void a() {
  int i=123;
  void b() {
    int j=321;
    printf("%d\n",i+j);
  }
  b();
}

int main() {
  a();
  return 0;
}
