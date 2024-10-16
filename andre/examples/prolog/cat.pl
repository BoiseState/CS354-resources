#!/bin/gprolog

cat(tom).
cat(phillip).
dog(jerry).

%same as cat(tom) :- true

animal(X) :- cat(X) ; dog(X).

%try queries animal(X). and cat(X).


