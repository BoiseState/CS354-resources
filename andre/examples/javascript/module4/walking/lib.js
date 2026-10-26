import { stat } from 'node:fs/promises';

export function print_dir(dir) {
    console.log(dir);
}

export async function nameNSize(dir) {
    const stats = await stat(dir);
    console.log(`${stats.size} ${dir}`);
    return stats.size;
}

export async function file_size(file) {
    return (await stat(file)).size;
}

export async function dir_size(dir, results) {
    const stats = await stat(dir);
    let total = stats.size;

    results.forEach((elem) => {
        total += elem;
    });

    console.log(`${total} ${dir}`);

    return total;
}

export async function dir(name, structure) {

}

