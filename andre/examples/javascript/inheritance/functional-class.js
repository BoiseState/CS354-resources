
//a class as a closure
var myClass = (function (a , b) {

    //Private instance variables
    var a = a;
    var b = b;

    var printAdd = function() {
        console.log(a + b)
    }

    //return public members
    //this is using the object literal '{}' to create a new object, but Object.create or using 'new' works too
    return {
        printAdd: printAdd
    };

});

let a = 1;
let instance1 = myClass(a,2);

a = 3;


instance1.printAdd();
