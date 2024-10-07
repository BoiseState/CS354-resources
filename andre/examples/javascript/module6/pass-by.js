let obj = {

    a: 123
};

let f = function(x) {
    x.a = 456;
    x = {}; //can change it to a different object, but it doesn't replace the actual.
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

console.log(prim); //1