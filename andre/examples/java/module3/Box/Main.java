public class Main {

    public static void main(String[] args) {
        BoxVisitor<Fuel> fuelConsumer = new BoxVisitor<>();
        Herbivore herbivore = new Herbivore();
        Panda panda = new Panda();

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
        //fuelBox.accept(herbivore); // illegal
        //fuelBox.accept(panda); // illegal


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
