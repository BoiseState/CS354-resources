
let a;

const main = function () {
    a = 1;
    const init = function () {
        let a;
        function modify () {
            a = 2;
        }

        modify();

    }
    init();
    console.log(a);
}

main();