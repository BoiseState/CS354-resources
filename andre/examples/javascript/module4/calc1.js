
const evaluate = function () {
    let stack = []; // Array.prototype has stack interface

    for (const arg of process.argv.slice(2)) {
        // number test first
        if (/^\d+/.test(arg)) {
            stack.push(parseInt(arg));
        } else if (arg === '+'){
            stack.push(stack.pop() + stack.pop());
        } else if (arg === '-') {
            stack.push(stack.pop() - stack.pop());
        } else if (arg === '*') {
            stack.push(stack.pop() * stack.pop());
        } else if (arg === '/') {
            stack.push(stack.pop() / stack.pop());
        } else {
            console.log(`ERROR: unexpected arg: ${arg}`);
        }
    }
    return stack.pop();
}

console.log(evaluate());