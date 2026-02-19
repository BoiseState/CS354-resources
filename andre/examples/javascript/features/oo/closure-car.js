
// use this to compare and contrast syntax/semantics of ES6+ class syntax and a functional closure
class ClassCar {
    #color;
    #started;

    constructor(color) {
        this.#color = color;
        this.#started = false;
    }

    getColor() {
        return this.#color;
    }

    setColor(color) {
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

const myOldsmobile = new ClassCar('brown');
console.log(`color of oldsmobile is ${myOldsmobile.getColor()}`);
myOldsmobile.color = 'blue' // this adds a new field to the object called color
console.log(`color of oldsmobile is ${myOldsmobile.color}`);

// Before all this new syntax, a programmer would use functional scope and closures.
//  note the use of var here. It's not required (you should still use let and const)
//   it is here to demonstrate the intention of early JS

const closureCar = function (c) {
    var color = c;
    var started = false;

    var getColor = function() {
        return color;
    };

    // a different way
    function setColor(c) {
        color = c;
    }

    var start = function () {
        started = true;
    }

    var rev = function() {

        if (!started) {
            start()
        }
        console.log("vrooom");
    }

    return {
        getColor,
        setColor,
        rev,
    }
}

const myCorvette = closureCar('red');
console.log(`color of corvette is ${myCorvette.getColor()}`);
myCorvette.color = 'blue' // this adds a new field to the object called color
console.log(`color of corvette is ${myCorvette.color}`);

