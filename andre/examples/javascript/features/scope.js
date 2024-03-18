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