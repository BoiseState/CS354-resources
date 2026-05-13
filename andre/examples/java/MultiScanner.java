import java.util.Scanner;

public class MultiScanner {

    public static void main(String[] args) {

        // input like "1 2" throws away the 2
        // in IA, need to create a scanner that it persistent for each program, but resets between them
        System.out.println("enter some data to scan");

        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Scanner one" + scan1.next());
        System.out.println("Scanner two" + scan2.next());

    }
}