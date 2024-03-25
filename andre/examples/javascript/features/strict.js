//"use strict";
variable = 5;
console.log(variable);

//try it again with the strict comment above!

//Strict scope ??? Why would anyone agree to this.

function sloppy() {
    variable = 5
}

(function() {
    "use strict";
    sloppy()
})()

function strict() {
    "use strict";
    variable = 5
}

(function() {
    strict()
})()

//credit: https://dev.to/frehner/exploring-javascript-s-strict-mode-8ip