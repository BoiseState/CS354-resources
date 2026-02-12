class BoxVisitor<U, R>{

    public R visit(Box<? extends U> host) {
        // ...
    }
}

class Herbavore<R> extends BoxVisitor<Plant, R> {}

class Panda<R> extends BoxVisitor<Bamboo, R> {}
