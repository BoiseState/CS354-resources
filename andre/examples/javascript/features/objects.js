
// objects are associative arrays

let obj = {
    field: 'value'
}

console.log(obj.field); // prints 'value'

// prototype is Object.prototype, granting "inherited" methods

console.log(obj.toString());

for (const objKey in obj) {
    console.log(objKey);
}