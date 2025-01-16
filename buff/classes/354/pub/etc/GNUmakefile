all:
	echo $(addsuffix .class,$(basename $(wildcard *.java)))
	$(guile (let ((msg (list "Hello " "world\n"))) \
	            (display (car msg)) \
	            (display (cadr msg))))
