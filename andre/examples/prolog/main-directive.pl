% main is only a conventional name. The name of the query that is used
% by the translator could be anything.
%
% this program will simply print the first X that is true in the
% database for cat(X).

cat(tom).
cat(phillip).
dog(jerry).

main :- cat(X),
	write(X), nl, halt.

:- initialization(main).