// credit: Javascript: the Good Parts

// memoizer is a function that creates memoized functions
// assumes functions return number values.
const memoizer = function (memo, fundamental) {
    const shell = function (n) {
        let result = memo[n];
        if (typeof result !== 'number') {
            result = fundamental(shell, n);
            memo[n] = result;
        }
        return result;
    };
    return shell;
};

const fibonacci = memoizer([0, 1], function (shell, n) {
    return shell(n - 1) + shell(n - 2);
});

const factorial = memoizer([1, 1], function (shell, n) {
    return n * shell(n-1);
});