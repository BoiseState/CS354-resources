import fs from 'node:fs';
import { join } from 'node:path';

// disclaimer, doesn't work, just shows callback problems, and inner functions as a solution.
function total_size(top, callback) {
    fs.stat(top, (err, stats) => {
        if (err) {
            console.error(err);
            callback(0);
        }

        let total = stats.size;

        if (stats.isFile()) {
             callback(total);
        } else {
            fs.opendir(top, (err, dir) => {
                if (err) {
                    console.error(err);
                    callback(0);
                }
                dir.read((err, entry) => {
                    total_size(join(top, entry.name), (err, size) => {
                        if (err) {
                            dir.close(() => callback(err));
                            return;
                        }

                        total += size;
                        dir.read(processEntry); // huh??
                    });
                })
            });
        }
    });
}

let total = 0;

total_size('../', (partial) => {
    total += partial;
});