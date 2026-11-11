// credit https://www.cs.rice.edu/~javaplt/nv4/pecs/
class Fuel {}
class Plant extends Fuel {}
class Bamboo extends Plant {}

class Box<T> {
    public void consumedBy(BoxVisitor<? super T> visitor) {}
}

class BoxVisitor<U>{
    public void consume(Box<? extends U> host) {}
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

        // fuelConsumer can consume each box
        fuelConsumer.consume(fuelBox);
        fuelConsumer.consume(plantBox);
        fuelConsumer.consume(bambooBox);

        // herbivore can consume Plant and Bamboo boxes
        // herbivore.consume(fuelBox); // illegal
        herbivore.consume(plantBox);
        herbivore.consume(bambooBox);

        // panda can consume Bamboo box
        // panda.consume(fuelBox); // illegal
        // panda.consume(plantBox); // illegal
        panda.consume(bambooBox);

        //contravariance

        // fuelBox can only be consumedBy fuelConsumer
        fuelBox.consumedBy(fuelConsumer);
        // fuelBox.consumedBy(herbivore); // illegal
        // fuelBox.consumedBy(panda); // illegal

        // plantBox can be consumedBy fuelConsumer and herbivore
        plantBox.consumedBy(fuelConsumer);
        plantBox.consumedBy(herbivore);
        // plantBox.consumedBy(panda); // illegal

        // bambooBox can be consumedBy fuelConsumer, herbivore and panda
        bambooBox.consumedBy(fuelConsumer);
        bambooBox.consumedBy(herbivore);
        bambooBox.consumedBy(panda);
    }
}
