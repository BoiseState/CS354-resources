
function listLength(node) {
    if (node === null) {
        return 0;
    } else {
        return 1 + listLength(node.next);
    }
}

// better, but programmer needs to provide initial value
function listLengthAccumulator(node, acc) {
    if (node === null) {
        return acc;
    } else {
        return listLengthAccumulator(node.next, acc + 1);
    }
}

// best, as it uses the same interface as the original listLength
function listLengthTail(L) {
    const listLengthAccumulator = function (node, acc){
        if (node === null) {
            return acc;
        } else {
            return listLengthAccumulator(node.next, acc + 1);
        }
    }
    return listLengthAccumulator(L.head, 0);
}