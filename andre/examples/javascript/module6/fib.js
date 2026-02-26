const fibonacci = function (n) {
    if (n < 2) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// count how many times fib is called by hiding the count in a closure
const fibCount = function() {
    let count = 0;

    return {
        fib: function(n) {
            count += 1;
            if (n < 2) return n;
            return this.fib(n - 1) + this.fib(n - 2);
        },
        getCount: function() { return count;}
    }
}