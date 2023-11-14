#!/bin/gprolog

cat(tom).

%same as cat(tom) :- true

animal(X) :- cat(X).

%try queries animal(X). and cat(X).


