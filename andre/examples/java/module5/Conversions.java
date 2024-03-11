import java.util.Scanner;

public class Conversions {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int next = (char) scan.nextInt();
            if (next == 'd') {
                System.out.println("found d!");
            }
            System.out.println(next);
            System.out.println((char)next);
        }
    }
}
