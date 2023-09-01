const sleep = require("./sleep");

/*
    Now use sleep directly with async and await
    much much easier to read!
*/

const somethingElse = async function() {
    await sleep(1000);
    console.log('a');

    await sleep(500);
    console.log('b');

    await sleep(250);
    console.log('c');
}

somethingElse();