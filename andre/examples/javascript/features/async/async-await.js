// async and await are modern idioms for asynchronous events in JS
// await can only appear inside a function labelled as async
// control goes to the promise, when, upon resolution (resolve is called)
// control comes back to the async function
const sleep = require("./sleep");

const somethingElse = async function() {
    await sleep(1000);
    console.log('a');

    await sleep(500);
    console.log('b');

    await sleep(250);
    console.log('c');
}

somethingElse();