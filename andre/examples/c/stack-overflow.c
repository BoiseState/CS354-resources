#include <stdio.h>
#include <stdlib.h>

static int a() {

	return a();
}

int main() {

  a();
  return 0;
}
