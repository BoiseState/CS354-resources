(define !
  (lambda (n) 
    (if (= n 0)
      1
      (* n (! (- n 1))))))


(define (!! n)
  (if (= n 0)
    1
    (* n (! (- n 1)))))


;(display (! 6))
;(newline)
;(display (! 7))
;(newline)

;(display (!! 6))
;(newline)
;(display (!! 7))
;(newline)