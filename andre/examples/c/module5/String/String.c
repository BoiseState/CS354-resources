/**

	String.c
		Contains a basic representation of a String.
 
*/
#include <stdio.h>
#include <stdlib.h>
#include "String.h"


StringPtr CreateString(char *source) {
    int n = strlen(source);
    StringPtr S = (StringPtr) malloc(sizeof(String));
    S->length = n;
    S->contents = (char *) malloc(sizeof(char) * n);
    strncpy(S->contents, source, n);

    return S;
}

int length(StringPtr S) {
    if (S == NULL) {
        return -1;
    } else {
        return S->length;
    }
}

char charAt(StringPtr S, int i) {
    if (S != NULL && i < S->length) {
        return S->contents[i];
    } else {
        return '\0';
    }
}

void FreeString(StringPtr S) {
    if (S != NULL) {
        free(S->contents);
        free(S);
    }
}