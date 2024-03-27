

int func(int a, int b) {
    int c = a + 2; // local variable
    return c + b;  // return value
}

int main() {
    int x = func(1, 2);  //main is the caller, func is callee
    return 0;
}