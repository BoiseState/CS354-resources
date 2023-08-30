import java.util.Arrays;
import java.util.List;

public class SumRecursive {

    public static int num = -1;

    public static int sum(int[] seq, int n) {
        if (n <= 0) {
            return 0;
        }
        return seq[n - 1] + sum(seq, n - 1);
    }

    public static int sumList(Integer[] seq, int n) {
        List<Integer> list = Arrays.asList(seq);
        if (n <= 0) {
            return 0;
        }
        return list.get(n - 1) + sumList(seq, n - 1);
    }

    public static void printUsage() {
        System.out.println("java SumRecursive <num>");
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            printUsage();
            System.exit(-1);
        }

        num = Integer.parseInt(args[0]);

        int[] seq = new int[num];

        for (int i = 0; i < num; i++) {
            seq[i] = i;
        }

        System.out.println(sum(seq, num));
    }
}