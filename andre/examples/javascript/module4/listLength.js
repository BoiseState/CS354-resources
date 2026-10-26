

function listLength(L) {
    if (L === null) {
        return 0;
    } else {
        return 1 + listLength(L.next);
    }
}

// better, but programmer needs to provide initial value
function listLengthAccumulator(L, acc) {
    if (L === null) {
        return acc;
    } else {
        return listLengthAccumulator(L.next, acc + 1);
    }
}

// best
function listLengthTail(L) {
    const listLengthAccumulator = function (L, acc){
        if (L === null) {
            return acc;
        } else {
            return listLengthAccumulator(L.next, acc + 1);
        }
    }
    return listLengthAccumulator(L, 0);
}