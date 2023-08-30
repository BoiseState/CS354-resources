public class SumIterative {

    public static int num = -1;

    public static int sum(int[] seq) {
        int s = 0;
        for (int v : seq)
            s += v;
        return s;
    }

    public static void printUsage() {
        System.out.println("java SumIterative <num>");
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

        System.out.println(sum(seq));
    }
}
