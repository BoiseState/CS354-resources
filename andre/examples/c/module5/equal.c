
struct A{
    int a, b;
};

struct B {
    int c, b;
};

void test(struct A param) {
    return;
}

int main() {

    struct B myB;
    test(myB);
    return 0;
}