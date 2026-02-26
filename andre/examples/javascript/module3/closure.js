// function arithmetic produces a function which
//  returns the next value in sum of the arithmetic series
//  this type of function is also called a generator
const arithmetic = function () {
    let total = 0;
    let next = 1;
    return function() {
        total += next;
        next += 1;
        return total;
    }
}

const series = arithmetic();

console.log(series()); // 1
console.log(series()); // 3
console.log(series()); // 6
