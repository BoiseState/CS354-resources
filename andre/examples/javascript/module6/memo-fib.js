// credit: Javascript: the Good Parts

// memoized fibonacci function.
// memoization caches the result of previous function calls, saving time
const fibonacci = function () {
    let memo = [0, 1];
    const fib = function (n) {
        let result = memo[n];
        if (typeof result !== 'number') {
            result = fib(n - 1) + fib(n - 2);
            memo[n] = result;
        }
        return result;
    };
    const print_memo = function() {
        console.log(memo);
    }
    return {
        fib,
        print_memo,
    };
}();