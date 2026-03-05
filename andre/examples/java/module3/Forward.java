public class Forward {

    private int a = b;
    private int b = 4;

    void A() { B(); }

    void B() { int b = c; }

    private int c = 3;
}
