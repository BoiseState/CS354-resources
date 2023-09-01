
let a = function (param) {
    return param;
};


//return of the parenthesis! 
a = (function (param) {
    return param;
});

//functions can be called
let b = a(12);

//functions can be assigned to other variables
let c = a; 
c(12);

//functions can be passed to other functions! 

const d = (function (e) {
    e(12);
});

d(a);
