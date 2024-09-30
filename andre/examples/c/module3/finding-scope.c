int a = 1; int b = 2;

void func() {
    int a = 4;
    {
        int temp = a;
        a = b;
        b = temp;
    }
}

int main() {
    int a = 13;
    func();
}