
let calc_actions = {
    stack: [],
    '+': function() {this.stack.push(this.stack.pop() + this.stack.pop());},
    '-': function() {this.stack.push(this.stack.pop() - this.stack.pop());},
    '*': function() {this.stack.push(this.stack.pop() * this.stack.pop());},
    '/': function() {this.stack.push(this.stack.pop() / this.stack.pop());},
    'NUMBER': function(numString) {this.stack.push(parseInt(numString));},
    '_DEFAULT_': function(arg) {console.log(`ERROR: unexpected arg: ${arg}`)},
}

let tree_actions = {
    stack: [],
    'NUMBER': function(numString) { this.stack.push(numString)},
    '_DEFAULT_': function(arg) {
        const s = this.stack.pop();
        this.stack.push([arg, this.stack.pop(), s]);
    }

}


const evaluate = function(actions) {

    for (const arg of process.argv.slice(2)) {
        let type;
        if (/^\d+/.test(arg)) {
            type = 'NUMBER';
        }

        if (actions.hasOwnProperty(type)) {
            actions[type](arg);
        } else if (actions.hasOwnProperty(arg)) {
            actions[arg]();
        } else {
            actions['_DEFAULT_'](arg);
        }
    }

    return actions.stack.pop();
}

calc_actions['exp'] = function() {
    this.stack.push(this.stack.pop() ** this.stack.pop());
};

console.log(evaluate(calc_actions));
//console.log(evaluate(tree_actions));