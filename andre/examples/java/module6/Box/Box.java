// credit https://www.cs.rice.edu/~javaplt/nv4/pecs/

class Box<T> {

    public void accept(BoxVisitor<? super T> visitor) {}
}
