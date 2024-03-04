//to be used in conjunction with pmap -x
#include <unistd.h>

int a() {
    int x = 14; //local stack variable
    sleep(1000);
    return 0;
}
int main() {

    a();
    return 0;
}