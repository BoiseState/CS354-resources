public class Labels {

    public static void main(String[] args) {
        int a = 3;
        LBL: {
            a = 4;
            while (true) {
                a--;
                if (a == 0) {
                    break LBL;
                }
            }
        }
        System.out.println(a);
    }
}
