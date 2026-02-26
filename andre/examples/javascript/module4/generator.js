// function arithmetic produces a function which
//  returns the next value in sum of the arithmetic series
//  this type of function is also called a generator
// javascript also support syntax for generators (ES6+). See bottom for example
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

const arithGen = function* () {
    let total = 0;
    let next = 1;

    while (true) {
        total += next;
        next += 1;
        yield total;
    }
}

const gen_series = arithGen();

console.log(gen_series.next().value); // 1
console.log(gen_series.next().value); // 3
console.log(gen_series.next().value); // 6