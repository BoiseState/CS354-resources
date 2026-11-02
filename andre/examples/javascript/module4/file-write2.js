const fs = require('node:fs/promises');

// demonstrates code that "uses" exceptions
let file = await fs.open('output.txt', 'w');
await file.writeFile('Hello, world!\n');
await file.close();
