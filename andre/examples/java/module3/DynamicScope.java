//credit: dragonbook page 33

import java.util.Random;

/**
 * exhibits that the name m must have dynamic scope, even though java
 * is considered "statically scoped"
 */
class DynamicScope {

    public static C randomObject () {
        Random r = new Random();
        return r.nextBoolean() ? new C() : new D();
    }

    public static void main(String[] args) {

        C x = randomObject();
        x.m(); //Which m?

        x = randomObject();
        x.m(); //Which m?
    }
}

class C             { void m() { System.out.println("Type C"); } }

class D extends C   { void m() { System.out.println("Type D"); } }