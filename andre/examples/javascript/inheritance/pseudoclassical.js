// JavaScript was worried about using too unfamiliar of concepts for mainstream programmers at the time
//Keywords and concepts that you are used to appear, but they do different things. 
//example: 'new' operator and constructor functions

//functions that are designed to be called with 'new' are capitalized by convention
var Vehicle = function (color) {
    //this does something different when the function is called with 'new' 
    this.color = color;
}

Vehicle.prototype.get_color = function () {
    return this.color;
}

//create an object

var myVehicle = new Vehicle('grey');

console.log(myVehicle.get_color());

//something bad without 'new'. 'this' is bound to the global object...

var otherVehicle = Vehicle('purple');

//console.log(otherVehicle.get_color()); // error! 

//console.log(this.color); //undefined? 


//Inheritance

var Car = function (color, topSpeed) {
    this.color = color;
    this.topSpeed = topSpeed;
}

Car.prototype = new Vehicle();

//add new method

Car.prototype.get_top_speed = function () {
    return this.topSpeed;
}

var myCar = new Car('yellow', 54);

console.log(myCar.get_color());

//unfortunately, no privacy available
myCar.color = 'purple';
console.log(myCar.color);
console.log(myCar.get_color());