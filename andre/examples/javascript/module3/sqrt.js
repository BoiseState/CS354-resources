
let sqrt = function (x) {
    let avg = function (x, y) {
        return (x + y) / 2;
    }
    let abs = function (x) {
        return x < 0? -x : x;
    }
    let square = function (x) {
        return x * x;
    }
    let good_enough = function (guess) {
        return abs(square(guess) - x) < 0.001;
    }
    let improve = function(guess) {
        return avg(guess, (x / guess));
    }
    let sqrt_iter = function (guess) {
        if (good_enough(guess)) {
            return guess;
        } else {
            return sqrt_iter(improve(guess));
        }
    }
    return sqrt_iter(1.0);
}