#include <stdio.h>
#include <stdlib.h>
#include "String.h"


int main(int argc, char **argv) {
    StringPtr S;
    char *source;

	if (argc != 2) {
			fprintf(stderr, "Usage: %s <string> \n",argv[0]);
			exit(1);
	}
	source = argv[1];

    S = CreateString(source);

    printf("information about the string:\n");
    printf("\tlength: %d\n", length(S));
    printf("\tcharAt index 3: %c\n", charAt(S, 3));

    FreeString(S);

	return 0;
}

