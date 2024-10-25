// gcc -Wall -g -o nonloc nonloc.c && ./nonloc
// objdump -dS nonloc

#include <stdio.h>

void a() {                // 0
  int i=123;              // 1
  void b() {              // 1
    int j=321;            // 2
    printf("%d\n",i+j);   // 2
  }                       // 1
  b();                    // 1
}                         // 0

int main() {              // 0
  a();                    // 1
  return 0;               // 1
}                         // 0
