
ordered_line(1,2,3).
ordered_line(4,5,6).
ordered_line(7,8,9).
ordered_line(1,4,7).
ordered_line(2,5,8).
ordered_line(3,6,9).
ordered_line(1,5,9).
ordered_line(3,5,7).

line(A,B,C) :- ordered_line(A,B,C).
line(A,B,C) :- ordered_line(A,C,B).
line(A,B,C) :- ordered_line(B,A,C).
line(A,B,C) :- ordered_line(B,C,A).
line(A,B,C) :- ordered_line(C,A,B).
line(A,B,C) :- ordered_line(C,B,A).

full(A) :- o(A).
full(A) :- x(A).

% empty must be called with an already instantiated A
empty(A) :- \+(full(A)).

same(A, A).
different(A, B) :- \+(same(A,B)).

% ! prevents backtracking
move(A) :- good(A), empty(A), !.

% strategy
good(A) :- win(A).
good(A) :- block_win(A).
good(A) :- split(A).
good(A) :- strong_build(A).
good(A) :- weak_build(A).

good(5).
good(1).
good(3).
good(7).
good(9).
good(4).
good(6).
good(8).

win(A) :- x(B), x(C), line(A,B,C).
block_win(A) :- o(B), o(C), line(A,B,C).
split(A) :- x(B), x(C), different(B,C), line(A,B,D), line(A,C,E), empty(D), empty(E).
strong_build(A) :- x(B), line(A, B, C), empty(C), \+(risky(C)).
weak_build(A) :- x(B), line(A, B, C), empty(C), \+(double_risky(C)).
risky(C) :- o(D), line(C,D,E), empty(E).
double_risky(C) :- o(D), o(E), different(D,E), line(C,D,F), line(C,E,G), empty(F), empty(G).

all_full :- full(1), full(2), full(3), full(4), full(5), full(6), full(7), full(8), full(9).

done :- ordered_line(A,B,C), x(A), x(B), x(C), write('I won!'), nl.
done :- all_full, write('Draw.'), nl.

getmove :- repeat, write('Please enter a move: '), read(X), empty(X), assertz(o(X)).
makemove :- move(X), !, assertz(x(X)).
makemove :- all_full.

print_square(N) :- o(N), write(' o ').
print_square(N) :- x(N), write(' x ').
print_square(N) :- empty(N), write('   ').

printboard :- print_square(1), print_square(2), print_square(3), nl,
                print_square(4), print_square(5), print_square(6), nl,
                print_square(7), print_square(8), print_square(9), nl.

clear :- retractall(x(_)), retractall(o(_)).

% main program entry point
play :- clear, repeat, getmove, respond.

respond :- ordered_line(A,B,C), o(A), o(B), o(C), printboard, write('You won!'), nl. % shouldn't happen!
respond :- makemove, printboard, done.

% set prolog unknown flag to fail, not error http://www.gprolog.org/manual/gprolog.html#set-prolog-flag%2F2
main :- set_prolog_flag(unknown, fail), play, nl, halt.

:- initialization(main).
