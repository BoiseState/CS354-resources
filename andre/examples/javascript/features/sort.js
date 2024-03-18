

//functions are higher order, and can be passed to other functions. 

//lets use array.sort as an example

var a = [3, 1, 4, 1, 5, 9]


var b = a.sort(function (x, y) {
    if (x < y) {
        return -1;
    }
    if (x > y) {
        return 1; 
    }
    return 0;
});

console.log(b);