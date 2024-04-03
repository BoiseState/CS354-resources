

let a = function ( x = 2, string = "hello") {
    console.log(`${string} ${x}`); //also, string interpolation!
}

a(); //default parameters are optional!

a(3);// however, cannot specify to only set the second value

a("world"); //normal js typechecking...
