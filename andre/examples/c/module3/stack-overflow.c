#include <stdio.h>
#include <stdlib.h>

int a() {
	return a();
}

int main() {
  a();
  return 0;
}
