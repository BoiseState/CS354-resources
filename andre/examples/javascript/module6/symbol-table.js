
let fib = function (n) {
    if (n < 2) {
        return 1;
    } else {
        return fib(n-1) + fib(n-2);
    }
};

const memoize = function(fn) {
    let cache = Object.create(null);
    return function(...args) {
        const key = args.join('');
        if (cache[key] === undefined) {
            cache[key] = fn(...args);
        }
        return cache[key];
    };
}

// follow the names through this one...
fib = memoize(fib);
console.log(fib(50));
