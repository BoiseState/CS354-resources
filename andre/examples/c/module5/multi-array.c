

// Create a 3D array of ints dynamically:
    int x, y, z;

    int ***array = (int ***) malloc(sizeof(int **) * x);

    int i, j;
    for(i = 0; i < x; i++) {
        array[i] = (int **) malloc(sizeof(int *) * y);
        for(j = 0; j < y; j++) {
            array[i][j] = (int *) malloc(sizeof(int) * z);
        }
    }


    // free it!
    for(i = 0; i < x; i++) {
        for(j = 0; j < T->y; j++) {
            free(array[i][j]);
        }
        free(array[i]);
    }
    free(array);

