public class DogCat {

    public static void main(String[] args) {
        Cat c = new Cat();
        Dog d = new Dog();
        c.equals(d);

        Cat c2 = new Cat();
        c.equals(c2); // which one should be used?
    }
}

class Cat {
    public boolean equals(Cat c) {
        return this == c; // won't work. For demo only
    }
}

class Dog {
    // dog stuff
}
