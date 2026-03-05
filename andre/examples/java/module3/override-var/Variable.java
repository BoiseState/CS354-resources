// Can variable names be overloaded in Java?

class Variable {
    int a = 4;

    void print() {
        System.out.println(a);
    }
}

class Override extends Variable {
    double a = 3.14;
}

class Main {
    public static void main(String[] args) {
        Override o = new Override();
        o.print(); // what should print?
    }
}
