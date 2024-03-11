
typedef struct {
    int a, b;
} A;

typedef struct {
    int a, b;
} B;

void test(A a) {
    return;
}

int main() {

    B myB;
    test(myB);
    return 0;
}