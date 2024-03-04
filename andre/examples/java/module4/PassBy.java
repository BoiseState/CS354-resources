public class PassBy {

    static class Container {
        int a;

        Container(int a) {
            this.a = a;
        }

        public void increment() {
            a++;
        }
    }

    static void primitive(int a) {
        a = a + 1;
    }

    static void reference(Integer a) {
        a = a + 1;
    }

    static void reference2(Container c) {
        c.increment();
    }

    public static void main(String[] args) {
        int prim = 3; 
        primitive(prim);

        System.out.println(prim);

        Integer ref = 3;

        reference(ref);

        System.out.println(ref);

        Container container = new Container(3); 

        reference2(container);

        System.out.println(container.a);
    }
}