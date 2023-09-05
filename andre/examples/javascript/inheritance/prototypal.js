//prototypal object orientation and inheritance gets rid of classes. 
//this is much more expressive, but also different.
//focus completely on the objects, and not on a class definition


//starting point, create a useful object

var myVehicle = {
    color: 'grey',
    get_color : function () {
        return this.color;
    }
};

console.log(myVehicle.get_color());

//use Object.create built-in
var myCar = Object.create(myVehicle);

//hmm no privacy here.
myCar.color = 'yellow';
myCar.topSpeed = 54;
myCar.get_top_speed = function (){
    return this.topSpeed;
};

console.log(myCar.get_color());
console.log(myCar.get_top_speed());

//inheritance is also possible from a pure datastructure, but that is more advanced.