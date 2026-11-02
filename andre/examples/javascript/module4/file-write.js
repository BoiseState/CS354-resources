const fs = require('node:fs');

fs.open('output.txt', 'w', (err, fd) => {
    if (err) {
        console.error('Open error:', err);
        return;
    }

    fs.write(fd, 'Hello, world!\n', (err) => {
        if (err) {
            console.error('Write error:', err);
        }

        fs.close(fd, (err) => {
            if (err) {
                console.error('Close error:', err);
            }
        });
    });
});