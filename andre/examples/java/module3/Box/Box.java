// credit https://www.cs.rice.edu/~javaplt/nv4/pecs/

class Box<T> {

    public <R> R accept(BoxVisitor<? super T, R> visitor) {
        // ...
    }
}
