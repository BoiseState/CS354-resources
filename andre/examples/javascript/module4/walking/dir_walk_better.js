import { opendir, stat } from 'node:fs/promises';
import { join } from 'node:path';

export async function dir_walk_better(top, fileFunc, dirFunc) {

    const stats = await stat(top);

    if (stats.isDirectory()) {
        let file;
        let results = []; // an array allows access to Array.prototype methods

        const dir = await opendir(top);
        for await (const dirent of dir) {
            results.push(await dir_walk_better(join(top, dirent.name), fileFunc, dirFunc));
        }
        return await dirFunc(top, results);
    } else {
        return await fileFunc(top);
    }
}

