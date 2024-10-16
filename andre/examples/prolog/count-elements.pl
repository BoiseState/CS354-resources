
count_elements([], 0).
count_elements([_|T], Count) :- count_elements(T, C2),
                                Count is C2 + 1.