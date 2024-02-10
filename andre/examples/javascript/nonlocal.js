
//corresponds to figure 3.5 in PLP IV

let a = function () {
    let x = 1;

    let b = function () {
        let x = 2;

        let c = function () {
            console.log("in c: x = " + x);

        }
        let d = function () {
            let x = 3;
            c();
        }
        console.log("in b: x = " + x);
        d();
    }

    let e = function () {
        console.log("in e: x = " + x);
        b();
    }
    e();
}

a();