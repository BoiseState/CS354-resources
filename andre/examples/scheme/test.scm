
;test program for the ! program
; try it by running with the --no-auto-compile flag

(load "factorial.scm")

(define (test-! n expected)   
  (if (equal? (! n) expected)
    (display "passed")
    (display "failed")))


(test-! 3 6)
(newline)