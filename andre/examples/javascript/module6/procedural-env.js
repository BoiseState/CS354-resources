const errNoBinding = function (searchVar) {
    console.log(`error! No binding for ${searchVar} found`);
}

const emptyEnv = function () {
    return function (searchVar) {
        errNoBinding(searchVar);
    }
}

const extendEnv = function (savedVar, savedVal, savedEnv) {
    return function (searchVar) {
        if (searchVar === savedVar) {
            return savedVal;
        } else {
            return applyEnv(savedEnv, searchVar);
        }
    }
}

const applyEnv = function (env, searchVar) {
    return env(searchVar);
}

//usage:

class Env {
    constructor() {
        this.env = emptyEnv();
    }

    addToEnv(variable, val) {
        this.env = extendEnv(variable, val, this.env);
    }

    getVal(variable) {
        return applyEnv(this.env, variable);
    }
}

let test = new Env();

test.addToEnv('x', 10);
test.addToEnv('y', 2);
test.addToEnv('z', 1);
test.addToEnv('x', 4);

console.log(test.getVal('x')); // 4
console.log(test.getVal('z')); // 1
console.log(test.getVal('y')); // 2
console.log(test.getVal('a'));