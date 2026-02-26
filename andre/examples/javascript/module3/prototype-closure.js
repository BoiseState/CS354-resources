const boxConstructor = function() {
    let value = 2;
    const getValue = function() {
        return value;
    };
    const setValue = function(n) {
        value = n;
    };

    return {
        getValue,
        setValue,
    }
}