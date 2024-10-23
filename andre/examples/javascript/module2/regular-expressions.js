//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_expressions

const re = /ab+c/; //nice, and looks like sed! 

//const re2 = //; //error: can't be empty though, thats a comment...

const re3 = new RegExp("ab+c");

const string = "aaabababaacabbc";

console.log(re3.test(string)); //true

console.log(re.exec(string)); // nice object: [ 'abbc', index: 11, input: 'aaabababaacabbc', groups: undefined ]