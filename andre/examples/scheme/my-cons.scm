(define (mycons a b)
    (display "(cons ") (display a) (display " ") (display b) (display ")")(newline)
    (cons a b))

(define a (mycons 'a '()))

(mycons 'b a)

(define (build-list n)
  (if (= n 0)
    '()
    (mycons n (build-list (- n 1)))))


(build-list 10)