public class Scopes {
    static int a;

    static void first() {
        a = 1;
    }

    static void second() {
        int a;
        first();
    }

    public static void main(String[] args) {
        a = 2;
        second();
        System.out.println(a);
    }
}