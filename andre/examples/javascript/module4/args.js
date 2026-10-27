
function main() {

    for (const arg of process.argv.slice(2)) {
        if (arg === '-l') {
            // -l logic
        } else if (arg === '-w'){
            // -w logic
        } else if (arg === '-c') {
            // -c logic
        } else {
            console.log(`ERROR: unexpected arg: ${arg}`);
        }
    }
}

main();
