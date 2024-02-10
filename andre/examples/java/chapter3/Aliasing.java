//todo: refactor to include aliasing/overloading etc
public class Aliasing {

    private int a;

    public Aliasing(int a) {
        this.a = a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return this.a;
    }

    public static void main(String[] args) {
        Aliasing obj = new Aliasing(1);
        Aliasing alias = obj;

        alias.setA(6);

        System.out.println(obj.getA());
    }
    
}
