// compile with -foptimize-sibling-calls

int a() {
    return a();
}

int main() {
    return a();
}