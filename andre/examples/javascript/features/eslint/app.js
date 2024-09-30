var test = 4 // var is bad

// hoisted function
function myFunc() {
    console.log("hello!") // ugly double-quoted string
    console.log(`hello!`) // single quoted string without interpolation

    // ugly formatting
}

if (0 == '0') {
    console.log("yuck!")
}

const item = new Object(); // use object literal instead

function handlgeThings(opts) {
    opts = opts || {};
}

// default parameters
var b = 1;
function count( a = b++) {
    console.log(a)
}

// too many spaces





