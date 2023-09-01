
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
export it! This is from CommonJS, a module framework. 
Note, only in nodejs. On browser side, a different implimentation is used: 
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Modules
*/
module.exports = obj();