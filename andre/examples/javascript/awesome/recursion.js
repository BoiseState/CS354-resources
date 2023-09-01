let recurs = function (n) {
    if (n === 0) {
        return [0];
    } else {
        return [n].concat(recurs(n - 1));
    }
}

console.log(recurs(5));