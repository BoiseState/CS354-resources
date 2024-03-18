const data = require("./json/data.json");

//for..in loops allow iteration through a JS object
for (let k in data) {
    console.log(data[k]); //note the familiar array access syntax.
    //console.log(data.k); //this doesn't work when accessing a variable field
}