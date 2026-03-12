const parent = {
    value: 2,
    method() {
        return this.value + 1;
    },
    getValue() {
        return this.value;
    },
};

console.log(parent.method());


const child = {
    __proto__: parent,
};

// open in node.js and play with attributes of child and parent
// can we modify child.value?