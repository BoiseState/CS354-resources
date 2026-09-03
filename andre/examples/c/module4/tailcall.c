// compile with -foptimize-sibling-calls or -O2

int a() {
    return a();
}

int main() {
    return a();
}