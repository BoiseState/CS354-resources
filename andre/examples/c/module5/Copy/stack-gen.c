#include <stdlib.h>

typedef struct Stack Stack;

#define TYPE int *

struct Stack {
    TYPE *data;
    int top;
    int capacity;
};

Stack *stack_create(int capacity) {
    Stack *stack = malloc(sizeof(Stack));
    if (stack == NULL) return NULL;

    stack->data = malloc(capacity * sizeof(TYPE));
    if (stack->data == NULL) {
        free(stack);
        return NULL;
    }

    stack->top = 0;
    stack->capacity = capacity;

    return stack;
}

int stack_push(Stack *stack, TYPE value) {
    if (stack->top == stack->capacity)
        return 0;

    stack->data[stack->top++] = value;
    return 1;
}

TYPE stack_pop(Stack *stack) {
    if (stack->top == 0)
        return NULL;

    return stack->data[--stack->top];
}

TYPEstack_peek(Stack *stack) {
    if (stack->top == 0)
        return NULL;

    return stack->data[stack->top - 1];
}

int stack_is_empty(Stack *stack) {
    return stack->top == 0;
}

void stack_destroy(Stack *stack) {
    free(stack->data);
    free(stack);
}