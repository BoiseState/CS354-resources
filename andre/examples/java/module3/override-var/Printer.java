// Can variable names be overloaded in Java?

class IntPrinter {
    int a = 4;

    void print() {
        System.out.println(a);
    }
}

class DoublePrinter extends IntPrinter {
    double a = 3.14;
   void print() {
       System.out.println(super.a);
   }
}

class Printer {
    public static void main(String[] args) {
        DoublePrinter o = new DoublePrinter();
        o.print(); // what should print?
    }
}
