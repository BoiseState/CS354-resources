// a function that creates an iterator.
const upto = function (m, n) {
    return {
        [Symbol.iterator]() {
            return this;
        },
        next() {
            return {
                value: m++,
                done: m>n,
            }
        }
    }
}

const iterator = upto(3, 5);

for (const val of iterator) {
    console.log(val);
}

const uptoGenerator = function* (m, n) {
    while (m<n) {
        yield m++;
    }
}

const generator = uptoGenerator(3, 5);

for (const val of generator) {
    console.log(val);
}



