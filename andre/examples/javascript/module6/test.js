var global = 2;

function a() {
    global += 1;
}

function b() {
    global /= 2;
}

function f(x, y) {
    console.log(global);
}

f(a(), 1 * 4);