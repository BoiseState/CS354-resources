// Can variable names be overloaded in Java?

class Printer {
    int a = 4;

    void print() {
        System.out.println(a);
    }
}

class DoublePrinter extends Printer {
    double a = 3.14;
//    void print() {
//        System.out.println(super.a);
//    }
}

class Main {
    public static void main(String[] args) {
        DoublePrinter o = new DoublePrinter();
        o.print(); // what should print?
    }
}
