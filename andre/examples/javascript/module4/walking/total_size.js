import { opendir, stat } from 'node:fs/promises';
import { join } from 'node:path';

export default async function total_size(top) {
    const stats = await stat(top);
    let total = stats.size;

    if (stats.isFile()) {
        return total;
    } else {
        const dir = await opendir(top);
        for await (const dirent of dir) {
            total += await total_size(join(top, dirent.name));
        }
        return total;
    }
}

console.log(await total_size('../'));