(define (mycons a b)
    (display "(cons ") (display a) (display " ") (display b) (display ")")(newline)
    (cons a b))

(define a (mycons 'a '()))

(mycons 'b a)