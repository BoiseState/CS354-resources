

function f(x, y, z) {
    x = x + 1;
    y = z;
    z = z + 1;
}

let i = 1;
let a = [];
a[1] = 10;
a[2] = 11;

f(i, a[i], i);
console.log(`i is ${i}`);
console.log(`a[1] is ${a[1]}`);
console.log(`a[2] is ${a[2]}`);