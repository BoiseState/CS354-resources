
int first_zero_row = -1;    /* none */

int i, j;

for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
        if (A[i][j]) goto next;
    }
    first_zero_row = i;
    break;
    next: ;
}

