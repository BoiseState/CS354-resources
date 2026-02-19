// Newer versions of JS added more syntax to hide the prototypal object model.
// keywords look like java, but behave differently under the hood
// get and set are especially different from Java
class Vehicle {
    #color;
    #started;

    constructor(color) {
        this.#color = color;
        this.#started = false;
    }

    get color() {
        return this.#color;
    }

    set color(color) {
        this.#color = color;
    }


    rev() {
        if (!this.#started) {
            this.#start()
        }
        console.log("vrooom");
    }

    #start () {
        this.#started = true;
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

const myCar = new Vehicle('brown');
myCar.rev();
// getters and setters look like they are directly modifying the private variable
myCar.color = 'blue';
console.log(`color of myCar is ${myCar.color}`);


//inheritance that is fooling you to look like Java
class Bus extends Vehicle {}

const myBus = new Bus('yellow');
//myBus.prototype is Vehicle

myBus.rev();
