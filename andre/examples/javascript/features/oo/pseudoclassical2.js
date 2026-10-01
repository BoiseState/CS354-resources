// a shorter example of the pseudoclassical way

const parent = {
    value: 2,
    method() {
        return this.value;
    },
};

console.log(parent.method());

const child = {
    __proto__: parent,
};

console.log(child.method());

child.value = 4;
console.log(child.method());

parent.value2 = 'Hello!';

console.log(child.value2);


// constructor version

Vehicle.prototype.get_color = function () {
    return this.color;
}

const myVehicle = new Vehicle('grey');

console.log(myVehicle.get_color());

const Car = function (color, topSpeed) {
    this.color = color;
    this.topSpeed = topSpeed;
}

Car.prototype = new Vehicle();

Car.prototype.get_top_speed = function () {
    return this.topSpeed;
}

const myCar = new Car('yellow', 54);

console.log(myCar.get_color());

//unfortunately, no privacy available
myCar.color = 'purple';
console.log(myCar.color);
console.log(myCar.get_color());
console.log(myCar.topSpeed);
console.log(myCar.get_top_speed());