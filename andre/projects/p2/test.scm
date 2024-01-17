; very simple suite to demonstrate super-duper

; adding tests to this is REQUIRED! 

; It is highly recommended to test each function

; It is highly recommended to follow the pattern shown here: 
;  https://github.com/BoiseState/CS354-resources/tree/master/andre/examples/scheme/test.scm


(load "super-duper.scm")


(display (super-duper 123 1))
(display (super-duper 123 2))

(display (super-duper '() 1))
(display (super-duper '() 2))

(display (super-duper '(x) 1))
(display (super-duper '(x) 2))

(display (super-duper '(x y) 1))
(display (super-duper '(x y) 2))

(display (super-duper '((a b) y) 3))
