(define (sum seq)
  (define (sum-iter seq res)
    (if (null? seq)
      res
      (sum-iter (cdr seq) (+ res (car seq)))))
  (sum-iter seq 0))


(display (sum '(1 2 3 4)))
(newline)