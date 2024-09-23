import fs from "fs";

if (process.argv.length !== 3) {
    console.log(`Usage: ${process.argv[1]} <file>`);
    process.exit(-1);
}

// using callbacks is a traditionally asynchronous technique
fs.readFile(process.argv[2], 'utf8', (err, data) => {
    if (err) throw err;
    console.log(data);
});