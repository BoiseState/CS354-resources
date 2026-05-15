// executes fn(inp) n times and prints the time
const logPerformance = function (fn, n, inp) {

    const before = performance.now();

    for (let i = 0; i < n; i++) {
        fn(inp);
    }

    const after = performance.now();
    console.log(`${fn.name} millis was ${after - before}`);
}