(define (sum seq)
  (define (sum seq res) ; also commonly called sum-iter
    (if (null? seq)
      res
      (sum (cdr seq) (+ res (car seq)))))
  (sum seq 0))


(display (sum '(1 2 3 4)))
(newline)