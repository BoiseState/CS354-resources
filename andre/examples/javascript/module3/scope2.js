// nested function version of static/dynamic scope program, but with no function names
let a;

(function () {
    a = 1;
    (function () {
        let a;
        (function () {
            a = 2;
        })();
    })();
    console.log(a);
})();