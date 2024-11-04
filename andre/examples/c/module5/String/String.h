#ifndef __STRING_H
#define __STRING_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct string String;
typedef struct string *StringPtr;

struct string {
	char *contents;
	int length;
};

/* prototypes */

StringPtr CreateString(char *source);

int length(StringPtr S);

char charAt(StringPtr, int);

void FreeString(StringPtr);

// For activities

/* Returns a new string that is a substring of the provided String */
StringPtr SubString(StringPtr, int begin, int end);

/* Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar. */
StringPtr Replace(StringPtr, char oldChar, char newChar);

/* Reverses the provided String in place */
void Reverse(StringPtr);
#endif /* __STRING_H */
