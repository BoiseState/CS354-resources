const dispatch_table = {
    '-l': function () { console.log('-l logic')},
    '-w': function () { console.log('-w logic') },
    '-c': function () { console.log('-c logic') },
}


function main() {

    for (const arg of process.argv.slice(2)) {
        if (dispatch_table.hasOwnProperty(arg)) {

            dispatch_table[arg](); // execute the function

        } else {
            console.log(`ERROR: unexpected arg: ${arg}`);
        }
    }
}

main();
