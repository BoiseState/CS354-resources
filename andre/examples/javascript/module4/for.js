
const tortoise = {
    name: 'jonathan',
    age: 193,
    birthYear: '1832',
}

const array = [
    1,2,3,
]

// array is iterable
for (const index in array) {
    console.log(index);
}

// object keys are iterable
for (const key in tortoise) {
    console.log(key);
}

// array elements are iterable
for (const elem of array) {
    console.log(elem);
}

// object values are not iterable
for (const elem of tortoise) {
    console.log(elem);
}

// Internal Iterator
array.forEach((elem, index) => {
    console.log(`${index}: ${elem}`);
});

// External Iterator
for (const elem of array) {
    console.log(elem);
}