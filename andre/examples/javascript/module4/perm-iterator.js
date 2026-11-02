// an iterator for permutations. Credit Higher Order Perl, by MJD

const patternToPermutation = function(pattern, items) {

    let r = [];
    for (val of pattern) {
        r.push(...items.splice(val, 1));
    }
    return r;
}

const incrementPattern = function(odometer) {
    let wheel = odometer.length-1;

    while (odometer[wheel] >= (odometer.length-1) - wheel && wheel >= 0) {
        odometer[wheel] = 0;
        wheel -= 1;
    }
    if (wheel < 0) {
        return undefined;
    } else {
        odometer[wheel] += 1;
        return odometer;
    }
}

const permute = function(items) {
    let pattern = new Array(items.length).fill(0);
    return function() {
        if (pattern === undefined) return;

        const result = patternToPermutation(pattern, [...items]);
        pattern = incrementPattern(pattern);
        return result;
    }
}

const it = permute(['red', 'yellow', 'blue','green']);

console.log(it());
console.log(it());
console.log(it());
console.log(it());
console.log(it());
console.log(it());
console.log(it());
console.log(it());
console.log(it());
console.log(it());