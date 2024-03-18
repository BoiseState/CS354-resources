
//global variables are bad

//calling var outside of any function creates a global variable
var something = 123;

console.log(global.something === 123); //true

//also adds 'value' to global
value = global.something;


//functions to the rescue!
var a = function() {
    var somethingElse = 123;
    console.log(global.somethingElse);
}();