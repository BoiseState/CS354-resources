

% include the other files.
% be aware that including a file that also contains a main predicate
% or an initialization directive will cause an error.

:- include('database.pl').
:- include('relations.pl').


main :- parent_child(X, sally),
	write(X), nl, halt.

:- initialization(main).