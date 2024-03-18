/*
    inheritance demo with the vehicle example
*/

//this is a little wierd because of the 'spec' and 'that'
var vehicle = function (spec) {
    var that = {};

    that.get_color = function () {
        return spec.color;
    }

    //same as in functional-class.js, but using a named object called 'that'
    return that;
};

var myVehicle = vehicle({color: 'grey'});

console.log(myVehicle.get_color());
console.log(myVehicle.color); //undefined

//inheritance
var car = function (spec) {
    var that = vehicle(spec);

    that.get_top_speed = function () {
        return spec.top_speed;
    }

    return that;
};

var myCar = car({color: 'purple', top_speed: 54 });

console.log(myCar.get_color());
console.log(myCar.get_top_speed());