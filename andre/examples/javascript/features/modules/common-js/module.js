
//define a simple functional class
let obj = (function () {
    let a = 1;
    let b = 2;

    let add = function () {
        return a + b;
    };

    return {
        add: add
    };
});

/*
export it! This is from CommonJS, the module framework used for many years
*/
module.exports = obj;