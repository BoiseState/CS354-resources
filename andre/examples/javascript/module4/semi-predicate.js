const Andre = {
    totalInvested: 0,
};

const Warren = {
    totalInvested: 1e10
};

const arr = [Andre, Warren];

const totalInvested = function(a) {
    return a.totalInvested;
};

// comparator for comparing two people by amount invested
let cache = {};
const byTotalInvested = function(a, b) {
    return (cache[a] ||= totalInvested(a)) - (cache[b] ||= totalInvested(b));
};

console.log(arr.sort(totalInvested));

// problem is that the cache always is a miss for Andre, as 0 is a falsey value
// ||= doesn't distinguish between a cache hit or miss when a hit is a falsey value
// Lisp people call this the semi-predicate problem
// JS doesn't have a good solution except for more syntax
// (a in cache ? cache[a] :  (cache[a] = totalInvested(a)))
// -
// (b in cache ? cache[b] :  (cache[b] = totalInvested(b)))