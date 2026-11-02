// Simple iterator. Credit Higher Order Perl, by MJD

// a function that creates an iterator.
let upto = function (m, n) {
    return {
        next() {
            return m<n ? m++: undefined;
        }
    }
}
let iterator = upto(3, 5);

iterator.next(); // 3
iterator.next(); // 4
iterator.next(); // undefined

// a while loop is awkward
iterator = upto(3, 5);

let val = iterator.next();
while (val !== undefined) {
    val = iterator.next();
}


// a function that creates an iterator and uses the Iterable protocol
upto = function (m, n) {
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

iterator = upto(3, 5);

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
