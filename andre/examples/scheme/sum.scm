(define (sum seq)
  (if (null? seq)
    0
    (+ (car seq) (sum (cdr seq)))))

(define (build-list n)
  (if (= n 0)
    '()
    (cons n (build-list (- n 1)))))

(display "input value for n")
(newline)

(display (sum (build-list (read))))
(newline)