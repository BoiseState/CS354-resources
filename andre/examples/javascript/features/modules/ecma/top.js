import {hello, MyObject, obj} from './module.mjs'

hello();

let myObj = new MyObject(4);
console.log(myObj.getA());