
// strings are primitive objects in the language, with supporting syntax

let str = 'hello';

// prototype is String.prototype
// has length property like arrays
// immutable
console.log(str[1]); // e
str[1] = 'a'
console.log(str[1]); // e
str.toUpperCase();
console.log(str);

// string concatenation is available as in java
console.log(str + ' world!');

// string interpolation is supported
console.log(`${str} world!`);

// strings are spreadable
console.log(...str);

// and strings can be compared using ===
console.log(str === 'hello'); // true

