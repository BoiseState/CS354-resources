let f = function() {
    const x = 12;
    return function(formal) {
        return formal + x;
    }
}

let a = f();
console.log(a(13)); //25