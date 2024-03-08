public class Recur {
    static void r(int a) {
        System.out.println(a);
        r(a+1);
    }
    public static void main(String[] args) {
        r(0);
    }
}
