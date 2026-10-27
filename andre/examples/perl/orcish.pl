# credit: Higher Order Perl, by MJD

@sorted_dates = sort chronologically @dates

%m2n =
    (jan =>  1, feb =>  2, mar =>  3,
    apr =>  4, may =>  5, jun =>  6,
    jul =>  7, aug =>  8, sep =>  9,
    oct => 10, nov => 11, dec => 12, );

{ my $cache;
    sub chronologically {
        ($cache[$a] ||= date_to_string($a))
            cmp
        ($cache[$b] ||= date_to_string($b))
    }
}

sub date_to_string {
    my ($m, $d, $y) = ($_[0] =- /(\w{3}) (\d+), (\d+)/);
    sprintf "%04d%02d%02d", $y, $m2n{lc $m}, $d;
}

