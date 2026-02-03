(define (echo x)
  (display x))

(echo 10)
(newline)

(echo '(1 2 3))
(newline)

(display "enter something to be echoed")
(newline)
(echo (read))
(newline)