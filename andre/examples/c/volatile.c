//gcc -Wall volatile.c -o volatile

#include <stdio.h> 
#include <stdlib.h> 
#include <unistd.h>
#include <pthread.h> 

void *subr(void *vargp) 
{
    int *value = (int *)vargp;
    while (*value == 0) {
	    sleep(1);
	    printf("Memory address unchanged\n");
    }
	printf("Memory address changed!\n");
    return 0;
}

int main()
{
    int value = 0; //change to volatile int, and register int
	pthread_t thread_id;
	pthread_create(&thread_id, NULL, subr, (void *)&value);
    sleep(5);
	printf("changing memory address\n");
    value = 1;
	pthread_join(thread_id, NULL);
	exit(0); 
}
