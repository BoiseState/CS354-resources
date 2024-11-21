let c = function(x) {
    let y = 3;
    let a = function(x) {
        y = x;
    };
    let b = function(x) {
        let y = 2;
        a(x);
        console.log(y);
    }
    b(x);
}
let x = 1;
c(x);