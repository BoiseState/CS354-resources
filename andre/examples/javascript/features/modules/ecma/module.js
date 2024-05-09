/*
    The syntax statements import and export can be used in recent version of JS.
    To use them in NodeJS, a package.js file is required with the field type and value module.
    Alternatively, you can name your javascript files .mjs

    Why are there so many ways to do something!
 */

export class MyObject {
    constructor(a) {
        this.a = a
    }

    getA() {
        return this.a
    }
}

//anything can be exported!
export function hello() {
    console.log("hello!");
}

export const obj = {

};

//alternatively
//export {MyObject, hello, obj};