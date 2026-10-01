
// arrays are objects that have Arrays.prototype as the prototype, and a special field, length

let a = [];

let b = {
    __proto__: Array.prototype
}

let c = new Array();

// Arrays are not like arrays in other languages.
// they are like normal javascript objects!

console.log(a[10]); // undefined, but not error

a[10] = 'some element'

console.log('a length is: ' + a.length);

for (let i = 0; i < a.length; i++) {
    console.log(a[i]);
}

b.push('a');
b.push('b');
b.push('c');

b.forEach((elem) => {
    console.log(elem);
});

// spread syntax is convenient
console.log(...b);
