// A reasonably annoying task is sorting dates (i.e. 'Apr 10, 1991') chronologically
// one strategy is to split the date string into its components, compare them by year, month or day
// lots of useful operator stuff here, and regex too!


dates = ['oct 10, 1946', 'apr 10, 1945', 'apr 10, 1946', 'dec 10, 2021', 'may 10, 1991',]

const m2n = {
    'jan': 1, 'feb': 2, 'mar': 3, 'apr': 4,
    'may': 5, 'jun': 6, 'jul': 7, 'aug': 8,
    'sep': 9, 'oct': 10, 'nov': 11, 'dec': 12,
};

// version 1:

// a list of 10000 dates calls this function 119927 times
// there are 239854 pattern matches
// each date is split into numbers 23.9 times on average, which is 22.9 times too many
const chronologically_v1 = function(a, b) {
    // juicy regex
    const aSep = a.match(/\w+|\d+/g);
    const bSep = b.match(/\w+|\d+/g);

    // are you excited about operators yet?
    return aSep[2] - bSep[2]
    || m2n[aSep[0].toLowerCase()] - m2n[bSep[0].toLowerCase()]
    || aSep[1] - bSep[1];
}

// version 2
const splitDate_v2 = function(x) {
    return x.match(/\w+|\d+/g);
}

// you might think this is equivalent, but it allows an important optimization, seen in v3.
const chronologically_v2 = function(a, b){
    const aSep = splitDate_v2(a);
    const bSep = splitDate_v2(b);

    return aSep[2] - bSep[2]
        || m2n[aSep[0].toLowerCase()] - m2n[bSep[0].toLowerCase()]
        || aSep[1] - bSep[1];
}

// version 3, better to cache the results of splitDate
// chronologically v3 would still be called 119927 times for a list of 10K dates
// however, splitDate is only called one time for each date, a total of 10K times
let cache = {};
const chronologically_v3 = function(a, b){
    const aSep = cache[a] ||= splitDate_v2(a);
    const bSep = cache[b] ||= splitDate_v2(b);

    return aSep[2] - bSep[2]
        || m2n[aSep[0].toLowerCase()] - m2n[bSep[0].toLowerCase()]
        || aSep[1] - bSep[1];
}

// ||= is the orcish maneuver. The OR Cache maneuver

console.log(dates.sort(chronologically_v3));
console.log(cache);
