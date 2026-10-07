// what gets printed?

let a = 1;

function test() {
    console.log('line 6: ' + a);

    let a = 2;

    console.log('line 10: ' + a);
}

test();

console.log('line 15: ' + a);