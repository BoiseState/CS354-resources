

const f1 = function (a) {
    return function () { console.log(a); }
}

let variable = 2;

const f2 = f1(variable); // f2 is the name of a function that was returned from f1.

variable += 1; // variable is now 3

f2(); //what gets printed?