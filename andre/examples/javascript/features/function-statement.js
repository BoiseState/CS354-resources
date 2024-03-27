foo(); //no error

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