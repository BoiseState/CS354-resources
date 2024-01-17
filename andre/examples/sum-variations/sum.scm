(define (sum seq)
  (if (null? seq)
    0
    (+ (car seq) (sum (cdr seq)))))

(display (sum '(1 2 3 4 5 6)))
(newline)