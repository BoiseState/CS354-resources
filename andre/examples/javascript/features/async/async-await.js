// TODO
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