; definition of recursive factorial
(define (fact n)
    (if (= n 0)
      1
      (* n (fact (- n 1)))))


(define !
  (lambda (n)
    (if (= n 0)
      1
      (* n (! (- n 1))))))


;(display (! 6))
;(newline)
;(display (! 7))
;(newline)

;(display (fact 6))
;(newline)
;(display (fact 7))
;(newline)