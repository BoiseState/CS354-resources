#include <stdio.h>
/* C's grammar allows repeatedly casting values

cast_expression
        : unary_expression
        | '(' type_name ')' cast_expression
        ;

*/

int main() {

    int x = (int)(double)(float)(char)(char)(long)(unsigned long long)12.1;

    // why? How about flooring real numbers?

    double floored = (double)(int)12.5;

    printf("floored number is %f\n", floored);

    return 0;
}