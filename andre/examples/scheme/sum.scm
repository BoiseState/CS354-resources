(define (sum seq)
  (if (null? seq)
    0
    (+ (car seq) (sum (cdr seq)))))

