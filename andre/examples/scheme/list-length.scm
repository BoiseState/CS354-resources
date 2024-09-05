; list-length : List -> Int
; usage : (list-length l) = the length of l

(define list-length
  (lambda (lst)
    (if (null? lst)
      0
      (+ 1 (list-length (cdr lst))))))