
/**

	SinglyLinkedList.c
		Contains a basic set of functions to manipulate a linked list.
 
*/

#include <stdio.h>
#include <stdlib.h>
#include "SinglyLinkedList.h"
#include "Job.h"

//TODO add the function pointers during construction! 
ListPtr createList(char *(*toString)(const void *), void (*freeObject)(void *)) {
    ListPtr L = (ListPtr) malloc(sizeof(List));
    L->head = NULL;
    L->toString = toString;
    L->freeObject = freeObject;
    return L;
}

NodePtr createNode(void *item) {
    NodePtr N = (NodePtr) malloc(sizeof(Node));
    N->item = item;
    return N;
}


void freeNode(NodePtr node) {
    if (node == NULL) return;

    //free the job, then free the node
    // TODO: freeJob(node->item);
    free(node);
}

void addAtFront(ListPtr L, NodePtr node) {
	if (node == NULL) return;
	if (L != NULL) {
		node->next = L->head;
		L->head = node;
	}
}

void printList(ListPtr L) {
    if (L == NULL) return;
    NodePtr n = L->head;
	while (n) {
        char *s = L->toString(n->item);
		printf(" %s -->", s);
        free(s); //todo experiment removing this
		n = n->next;
	}
    printf(" NULL \n");
}


void freeList(ListPtr L) {
    if (L == NULL) return;
    NodePtr n = L->head;
	while (n) {
        NodePtr next = n->next;
        //free the job, free the node, move to next
        // freeJob(n->item);
        L->freeObject(n->item);
        free(n);
        n = next;
	}
    free(L);
}

