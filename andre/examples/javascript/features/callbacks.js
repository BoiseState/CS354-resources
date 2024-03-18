const sleep = require("./sleep");

let doSomething = (async function (millis, callback) {
    await sleep(millis);
    callback();
});

doSomething(1000, function() {
    console.log('2');
});

console.log('1!');



//chaining callbacks as you might need to do when writing to multiple database tables or something
//yuck!
doSomething(1000, function() {
    console.log('a');

    if (true) {

        doSomething(500, function() {
            console.log('b');
            if (false) {

            } else {
                doSomething(250, function() {
                    console.log('c');
                });
            }
        });
    }
});

