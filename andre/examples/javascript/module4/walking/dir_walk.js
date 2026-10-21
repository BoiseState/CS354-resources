import { opendir, stat } from 'node:fs/promises';
import { join } from 'node:path';

export async function dir_walk(top, code) {

    code(top);

    const stats = await stat(top);

    if (stats.isDirectory()) {
        const dir = await opendir(top);
        for await (const dirent of dir) {
            await dir_walk(join(top, dirent.name), code);
        }
    }
}

