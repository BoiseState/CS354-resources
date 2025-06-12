interface F { int f(F f, int n); }

public class Y {

    private static F fact=(F f, int n) -> {
	return n==0 ? 1 : n*f.f(f,n-1);
    };
    // or: ... -> n==0 ? 1 : n*f.f(f,n-1);

    private static int Y(F f, int n) {
	return f.f(f,n);
    }

    public static void main(String[] args) {
	System.out.println(Y(fact,5));
    }

}
