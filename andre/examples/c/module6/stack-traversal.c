#include <stdio.h>
#include <stdlib.h>

static void **global;

void *b(int param1, void *param2) {


	printf("IN B()\n");
	void *local = (void *)0xBA5EBA11BA5EBA11;

	register void *sp asm ("sp");
	printf("b() stack pointer: %p\n", sp);
	register void *fp asm ("r29");
	printf("b() frame pointer: %p\n", fp);
	
	printf("b(): &param1:\t%p\tparam1:\t%d\n", &param1, param1);
	printf("b(): &param2:\t%p\tparam2:\t%p\n", &param2, param2);
	printf("b(): &local: \t%p\tlocal:\t%p\n", &local, local);

	printf("main() local var address - b() local var address %ld bytes\n", (global - &local) * sizeof(void *));

	int i = 0;
	while (i <= (global - &local)) {

		printf("data at location %p is: %p\n", (&local + i), *(&local + i));
		i += 1;
	}

	return &local;
}

void *a(int param1, void *param2) {

	printf("IN A()\n");

	void *local = (void *)0xBA5EBA11BA5EBA11;

	register void *sp asm ("sp");
	printf("a() stack pointer: %p\n", sp);
	register void *fp asm ("r29");
	printf("a() frame pointer: %p\n", fp);
	
	printf("a(): &param1:\t%p\tparam1:\t%d\n", &param1, param1);
	printf("a(): &param2:\t%p\tparam2:\t%p\n", &param2, param2);
	printf("a(): &local: \t%p\tlocal:\t%p\n", &local, local);

	printf("main() local var address - a() local var address %ld bytes\n", (global - &local) * sizeof(void *));

	int i = 0;
	while (i <= (global - &local)) {

		printf("data at location %p is: %p\n", (&local + i), *(&local + i));
		i += 1;
	}

	return b(param1, param2);
}


int main() {


	register void *sp asm ("sp");
	printf("main() stack pointer: %p\n", sp);
	register void *fp asm ("r29");
	printf("main() frame pointer: %p\n", fp);

	void *ptr1 = (void *) 1;
	global = &ptr1;
	printf("main(): &ptr1:\t\t%p ptr1:\t%p\n", &ptr1, ptr1);
	printf("main(): &global:\t%p global:\t%p\n", &global, global);
	a(1 + 1, (void *)0xDEADBEEFDEADBEEF);
}
