// credit https://www.cs.rice.edu/~javaplt/nv4/pecs/
class Fuel {}
class Plant extends Fuel {}
class Bamboo extends Plant {}

class Box<T> {
    public void accept(BoxVisitor<? super T> visitor) {}
}

class BoxVisitor<U>{
    public void visit(Box<? extends U> host) {}
}

public class Main {

    public static void main(String[] args) {
        BoxVisitor<Fuel> fuelConsumer = new BoxVisitor<>();
        BoxVisitor<Plant> herbivore = new BoxVisitor<>();
        BoxVisitor<Bamboo> panda = new BoxVisitor<>();

        Box<Fuel> fuelBox = new Box<>();
        Box<Plant> plantBox = new Box<>();
        Box<Bamboo> bambooBox = new Box<>();

        //covariance

        // fuelConsumer can use each box
        fuelConsumer.visit(fuelBox);
        fuelConsumer.visit(plantBox);
        fuelConsumer.visit(bambooBox);

        // herbivore can use Plant and Bamboo boxes

        // herbivore.visit(fuelBox); // illegal
        herbivore.visit(plantBox);
        herbivore.visit(bambooBox);

        // panda can use Bamboo box

        // panda.visit(fuelBox); // illegal
        // panda.visit(plantBox); // illegal
        panda.visit(bambooBox);

        //contravariance

        // fuelBox can only be visited by fuelConsumer
        fuelBox.accept(fuelConsumer);
        // fuelBox.accept(herbivore); // illegal
        // fuelBox.accept(panda); // illegal

        // plantBox can be visited by fuelConsumer and herbivore
        plantBox.accept(fuelConsumer);
        plantBox.accept(herbivore);
        // plantBox.accept(panda); // illegal

        // bambooBox can be visited by fuelConsumer, herbivore and panda
        bambooBox.accept(fuelConsumer);
        bambooBox.accept(herbivore);
        bambooBox.accept(panda);
    }
}
