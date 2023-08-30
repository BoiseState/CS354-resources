public class Scope {
    public static void main(String[] args) {
        int a = 12;

        {
            int b = 13;
            int c = a + b;
        }

        int c = a + b; //error! 
    }
}