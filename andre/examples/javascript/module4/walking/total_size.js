import { opendir, stat, access } from 'node:fs/promises';

async function exists(path) {
    try {
        await access(path);
        return true;
    } catch {
        return false;
    }
}

export default async function total_size(top) {
    let total = 0;

    if (! await exists(top)) {
        return total;
    } else {
        const stats = await stat(top);
        total += stats.size;
        if (stats.isFile()) {
            return total;
        } else {
            const dir = await opendir(top);
            for await (const dirent of dir) {
                const stats = await stat(dirent.name);
                total += stats.size;
            }
        }
        return total;
    }
}

console.log(await total_size('./'));