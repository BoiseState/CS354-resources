
;taken from SICP chapter 1. Note the scope granted by nested functions.
;also consider the value of x used in each of the bodies of the nested
;routines. Closure property required!
(define (sqrt x)
  (define (average x y)
    (/ (+ x y) 2))
  (define (good-enough? guess)
    (< (abs (- (square guess) x)) 0.001))
  (define (improve guess)
    (average guess (/ x guess)))
  (define (sqrt-iter guess)
    (if (good-enough? guess)
      guess
      (sqrt-iter (improve guess))))
  (sqrt-iter 1.0))

(display (sqrt 100)) (newline)