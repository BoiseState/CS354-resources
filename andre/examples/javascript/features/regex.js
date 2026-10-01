
// syntax for regex exist in the language

const lowercase = /[a-z]+/

const str = "hello WORLD";
console.log(lowercase.exec(str));

// see official documentation for more: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_expressions