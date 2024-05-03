
const data = require("./data.json");

console.log(JSON.stringify(data));
console.log(data);

//can also access specific fields to get their values, like a hashtable! 
console.log(data.key);

//or access it with a variable, in case you don't know what the field is
let string = 'key2';
console.log(data[string]);