
//a class as a closure
var myClass = (function (a , b) {

    //Private instance variables
    var a = a;
    var b = b;

    var printAdd = function() {
        console.log(a + b)
    }

    //return public members
    return {
        printAdd: printAdd
    };

});

//two instances of the class
var instance1 = myClass(1, 2);
var instance2 = myClass(3, 4);

instance1.printAdd();
instance2.printAdd();

//can access, but doesn't modify
instance1.a = 4;

instance1.printAdd();

//this actually creates a new attribute on instance1
console.log(instance1.a);