


int function(const int a, const register int b) {
    //a = 4; //error!
    return 0;
}

int main() {
    function(1, 2);
    return 0;
}