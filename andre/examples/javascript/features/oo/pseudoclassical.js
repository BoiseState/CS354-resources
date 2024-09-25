// from https://developer.mozilla.org/en-US/docs/Web/JavaScript/Inheritance_and_the_prototype_chain

const parent = {
    value: 2,
    method() {
        return this.value + 1;
    },
};

console.log(parent.method()); // 3
// When calling parent.method in this case, 'this' refers to parent

// child is an object that inherits from parent
const child = {
    __proto__: parent,
};
console.log(child.method()); // 3
// When child.method is called, 'this' refers to child.
// So when child inherits the method of parent,
// The property 'value' is sought on child. However, since child
// doesn't have an own property called 'value', the property is
// found on the [[Prototype]], which is parent.value.

child.value = 4; // assign the value 4 to the property 'value' on child.
// This shadows the 'value' property on parent.
// The child object now looks like:
// { value: 4, __proto__: { value: 2, method: [Function] } }
console.log(child.method()); // 5

// JavaScript was worried about using too unfamiliar of concepts for mainstream programmers at the time
// Keywords and concepts that you are used to appear, but they do different things.
// example: 'new' operator and constructor functions

// functions that are designed to be called with 'new' are capitalized by convention
const Vehicle = function (color) {
    //this does something different when the function is called with 'new' 
    this.color = color;
}

// Objects in JS use prototypal inheritance chain.
// to find a name, the current object is searched, then its prototype and so on up the chain
Vehicle.prototype.get_color = function () {
    return this.color;
}

//create an object
//This should be done with the new keyword. If not, 'this' refers to the global 'this'
const myVehicle = new Vehicle('grey');

console.log(myVehicle.get_color());

// Bad without 'new'. 'this' is bound to the global object...
const otherVehicle = Vehicle('purple');
console.log(this.color); //undefined?

// Inheritance
var Car = function (color, topSpeed) {
    this.color = color;
    this.topSpeed = topSpeed;
}

Car.prototype = new Vehicle();

//add new method

Car.prototype.get_top_speed = function () {
    return this.topSpeed;
}

const myCar = new Car('yellow', 54);

console.log(myCar.get_color());

//unfortunately, no privacy available
myCar.color = 'purple';
console.log(myCar.color);
console.log(myCar.get_color());
console.log(myCar.get_top_speed());