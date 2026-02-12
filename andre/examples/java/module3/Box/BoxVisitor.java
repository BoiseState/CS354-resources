class BoxVisitor<U>{

    public void visit(Box<? extends U> host) {}
}

class Herbivore extends BoxVisitor<Plant> {}

class Panda extends BoxVisitor<Bamboo> {}
