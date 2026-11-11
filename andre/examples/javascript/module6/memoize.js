// Credit: Higher Order Perl by MJD

let fib = function (n) {
    if (n < 2) {
        return 1;
    } else {
        return fib(n-1) + fib(n-2);
    }
};

// memoize manipulates the runtime symbol table to replace your function with another
const memoize = function(fn, keygen = function(...args) { return args.join(',')}) {
    let cache = Object.create(null);
    return function(...args) {
        // const key = args.join(''); // https://blog.risingstack.com/the-worlds-fastest-javascript-memoization-library/
        const key = keygen(args);
        if (cache[key] === undefined) {
            cache[key] = fn(...args);
        }
        return cache[key];
    };
}

memo_fib = memoize(fib, JSON.stringify);
// calling memo_fib(50) only caches the result of memo_fib(50), not for memo_fib(49) or others

// wow!
fib = memoize(fib, JSON.stringify);
console.log(fib(50));