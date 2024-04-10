public class GenericMethods { //todo: extends

    public <T> void compute(T parameter) {

    }

    public <T extends Comparable<T>> void compute2(T bounded) {

    }

    public <T super Comparable<T>> void compute1(T bounded) { //TODO:

    }
}

class Bounded<T>{ //todo T super Number

}
