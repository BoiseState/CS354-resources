class Fuel {

    private boolean consumed;
    public Fuel() {
        consumed = true;
    }
}

class Plant extends Fuel {}

class Bamboo extends Plant {}
