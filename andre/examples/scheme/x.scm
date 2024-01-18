(define (x n)
    (if (= n 0)
        '()
        (cons n (x ( - n 1)))))