const fs = require('node:fs/promises');

// demonstrates exception handling in JS
let file;

try {
    file = await fs.open('output.txt', 'w');
    await file.writeFile('Hello, world!\n');
} catch (err) {
    console.error('File error:', err);
} finally {
    if (file) {
        try {
            await file.close();
        } catch (err) {
            console.error('Close error:', err);
        }
    }
}