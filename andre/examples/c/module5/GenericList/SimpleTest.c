#include <stdio.h>
#include <stdlib.h>
#include "SinglyLinkedList.h"
#include "Job.h"


int main(int argc, char **argv) {	
	int i;
	int n;
    ListPtr L;
	NodePtr node;
    JobPtr j;

	if (argc != 2) {
			fprintf(stderr, "Usage: %s <list size> \n",argv[0]);
			exit(1);
	}
	n = atoi(argv[1]);

	L = createList(jobToString, freeJob);

	for (i=0; i<n; i++) {
        j = createJob(i, " dummy job");

		node = createNode(j);

		if (node == NULL) {
			printf("Error allocating node for linked list\n");	
			exit(1);
		}
		addAtFront(L, node);
	}

	if (n < 10) printList(L);

    freeList(L);

	return 0;
}

