// what gets printed?

let a = 1;

function test() {
    console.log(a);

    var a = 2;

    console.log(a);
}

test();

console.log(a);