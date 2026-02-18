// callback functions are a typical way of handling asynchronous events
// note the => syntax is shorthand for a lambda function.
// (millis, callback) => { ... }
//   is the same as
// function(millis, callback) { ... }

let doSomething =  (millis, callback) => {
    setTimeout(callback, millis)
};

doSomething(1000, () => {
    console.log('2');
});

console.log('1');



//chaining callbacks as you might need to do when writing to multiple database tables or something
doSomething(1000, () => {
    console.log('a');
    doSomething(500, () => {
        console.log('b');
        doSomething(250, () => {
            console.log('c');
        });
    });
});

