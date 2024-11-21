(define (myif predicate then-clause else-clause)
  (cond (predicate then-clause)
    (else else-clause)))

;(display (myif (= 2 3) 0 5)) (newline)
;(display (myif (= 1 1) 0 5)) (newline)

(define (square x)
  (* x x))

(define (average x y)
  (/ (+ x y) 2))

(define (improve guess x)
  (average guess (/ x guess)))

(define (good-enough? guess x)
  (< (abs (- (square guess) x)) 0.001))

(define (sqrt-iter guess x)
  (good-enough? guess x)
  (if (good-enough? guess x) ;modified
    guess
    (sqrt-iter (improve guess x)
      x)))

(define (sqrt x)
  (sqrt-iter 1.0 x))

(display (sqrt 15))