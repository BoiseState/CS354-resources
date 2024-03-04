public class Forward {

    //private int a = b; // illegal
    private int b = 4;

    void A() { B(); } //Not illegal

    void B() { int b = c; } //fine here though

    private int c = 3; //ick

}
