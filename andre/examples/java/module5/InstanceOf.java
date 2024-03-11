//credit: dragonbook page 33

import java.util.Random;

/**
 * exhibits that the name m must have dynamic scope, even though java
 * is considered "statically scoped"
 */
class InstanceOf {

    public static C randomObject () {
        Random r = new Random();
        return r.nextBoolean() ? new C() : new D();
    }

    public static void main(String[] args) {

        C x = randomObject();
        //Old pattern
        if (x instanceof D) {
            D d = (D) x;
            d.m();
        }

        //new pattern
        if (x instanceof D d) {
            d.m();
        }
    }
}

class C             { void m() { System.out.println("Type C"); } }

class D extends C   { void m() { System.out.println("Type D"); } }