// Newer versions of JS added more syntax to hide the prototypal object model.
// keywords look just like java, but behave differently under the hood
class Vehicle {
    constructor(color) {
        this.vColor = color;
    }

    // get vColor() { return this.vColor } //trap! Infinite recursion
    get color() {
        return this.vColor;
    }

    method() {
        console.log("I am here!");
    }

    #privateMethod () {
        console.log("privacy :) ");

    }
}

// additionally, class can be used in an expression
const Vehicle2 = class {
    constructor(color) {
        this.color = color;
    }
}

//strangely, classes can have names and be assigned to others in an expression
const Vehicle3 = class Vehicle4 {
    constructor(color) {
        this.color = color;
    }
}

//inheritance that is fooling you to look like Java
class Bus extends Vehicle {

}

const myBus = new Bus();
//myBus.prototype is Vehicle
