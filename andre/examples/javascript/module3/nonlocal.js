
//corresponds to figure 3.5 in PLP IV

const a = function () {
    let x = 1;

    const b = function () {
        let x = 2;

        const c = function () {
            console.log("in c: x = " + x);

        }
        const d = function () {
            let x = 3;
            c();
        }
        console.log("in b: x = " + x);
        d();
    }

    const e = function () {
        console.log("in e: x = " + x);
        b();
    }
    e();
}
a();