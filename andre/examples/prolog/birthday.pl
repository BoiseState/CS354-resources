% date(month, day, year).
birthday(taylor, date(12, 13, 1989)).
birthday(olivia, date(01, 21, 2014)).

before(date(M1, D1, Y1), date(M2, D2, Y2)) :- (Y1 \== Y2, Y1 < Y2);
                                             (Y1 == Y2, M1 \== M2, M1 < M2);
                                             (Y1 == Y2, M1 == M2, D1 < D2).

whosOlder(Person, Date) :- birthday(Person, Date1), before(Date1, Date).