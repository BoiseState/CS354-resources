let a = function(x) {
    y = x;
};

let b = function(x) {
    let y = 2;
    a(x);
    console.log(y);
};

b(1);