import { stat } from 'node:fs/promises';
import total_size from "./total_size.js";
import {print_dir, nameNSize, file_size, dir_size, fileObj, dirObj} from "./lib.js";
import {dir_walk} from "./dir_walk.js";
import {dir_walk_better} from "./dir_walk_better.js";


// total size of a directory
console.log(await total_size('../'));

// more general function
// what are the advantages here?
await dir_walk('../', print_dir);

// print_dir is trivial, can use anonymous function instead
await dir_walk('../', (dir) => {
    console.log(dir);
});

// name and size this time.
await dir_walk('../', async (dir) => {
    const stats = await stat(dir);
    console.log(`${stats.size} ${dir}`);
});

// And from the library
await dir_walk('../', nameNSize);

// problem: we cannot get total size, or other aggregation of data, yet...
console.log(`total size is ${await dir_walk_better('../', file_size, dir_size)}`);

console.log(
    JSON.stringify(
        await dir_walk_better('../', fileObj, dirObj)
        , null, 2)
);