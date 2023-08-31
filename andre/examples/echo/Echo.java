public class Echo {

    public static void echo(Object x) {
        System.out.println(x.toString());
    }
    public static void main(String[] args) {
        echo("123");

        echo(123);
    }
}
