let obj = {

    a: 123
};

let f = function(x) {
    //x.a = 456;
    x = {}; //cannot change it to a different object
};

console.log(obj.a); //123

f(obj);

console.log(obj.a) //456

let prim = 1;

f = function(x) {
    x = 2;
}

console.log(prim); //1

f(prim);

console.log(prim); //2