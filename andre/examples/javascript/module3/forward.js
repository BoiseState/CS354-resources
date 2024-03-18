var a = c; var c = 4; //legal but a is undefined

var b= f(); //legal forward reference
function f() { return 2; }