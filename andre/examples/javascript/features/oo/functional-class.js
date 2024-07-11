
//a class as a closure
const myClass = (function (a , b) {

    //Private instance variable
    let c = a + b;

    let printAdd = function() {
        console.log(a + b)
    }

    //return public members
    //this is using the object literal '{}' to create a new object, but Object.create or using 'new' works too
    return {
        printAdd: printAdd
    };

});

//two instances of the class
const instance1 = myClass(1, 2);
const instance2 = myClass(3, 4);

instance1.printAdd();
instance2.printAdd();

//can actually create a new member with the same name, but doesn't modify
instance1.c = 4;

instance1.printAdd();

//this actually creates a new attribute on instance1
console.log(instance1.c);