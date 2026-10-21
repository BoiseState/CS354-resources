import { stat } from 'node:fs/promises';

export function print_dir(dir) {
    console.log(dir);
}

export async function nameNSize(dir) {
    const stats = await stat(dir);
    console.log(`${stats.size} ${dir}`);
}


