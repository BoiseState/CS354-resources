// Antiquity means the ancient past, especially the period before the Middle Ages.
// Javascript was invented a few decades ago.
// Its come a long way, and has many ways of accomplishing the same thing.
// Here is a short summary of the features that are used but not recommended.

// try these in a NodeJS interpreter!
// Type conversions cause strange behavior in JS

'' == '0'
0 == ''
0 == '0'

false == 'false'
false == '0'

false == undefined
false == null
null == undefined

' \t\r\n' == 0

// best practice is to always use === and !==

// Numbers are sometimes not numbers...

typeof NaN === 'number'

0 + '0'

0 + 'string'

NaN === NaN
NaN !== NaN

// Infinity exists too!

typeof Infinity === 'number'

//isNaN demo

isNaN(NaN);
isNaN('0');
isNaN('string');

//isFinite demo

isFinite(NaN);
isFinite(Infinity);
isFinite('0');

//global variables are bad

// calling var outside any function creates a global variable
var something = 123;

console.log(global.something === 123); //true

//also adds 'value' to global
value = global.something;

// functions offer function scope, and var is okay there
var a = function() {
    var somethingElse = 123;
    console.log(global.somethingElse);
}();

foo(); //no error

/*JS has awful scoping, at least until ES6 (although the old behavior is supported)

    var   - declare variables as global or function scope, but not block scope. Hoisting* behaviour
    const - declare variables with block scope that can never be reassigned
    let   - declare variables with block scope that can be reassigned

    * - see ../not-good/function-statement.js
*/

var scope = function() {// javascript has blocks, but not block scope see examples/scope/scope.java

    var a = 12;

    {
        var b = 13;
        var c = a - b;
    }

    var c = a + b; //completely fine

    console.log(c);

//most programming languages, the best practice is to declare variables when they are first used

//in Javascript, its often best to declare them all at the top of a function

}();

//In ES6, javascript added let, adding block scope
var letscope = function() {

    let d = 12;

    {
        let e = 13;
        let f = d - e;
    }

    let f = d + e; //fails! Thats good

    console.log(f);

    //most programming languages, the best practice is to declare variables when they are first used

    //in Javascript, its often best to declare them all at the top of a function

}();

//function statement
function foo() {
    console.log('foo');
};

boo(); //error

//functions are variables containing values
var boo = function () {
    console.log('boo');
};

//best practice is to avoid using the function statement, use an assignment instead


//functions can also be written with a notation new to ES6

let x = function(x, y) {
    return x * y;
}

x = (x, y) => {x * y};

void 'something'; //returns undefined

//bet practice, don't use void

// semicolon insertion...

const semi = function () {
    return
    {
        // object return was intended.
    }

    // actually ends up :(
    /*
    return;
    {
    };
     */
}
