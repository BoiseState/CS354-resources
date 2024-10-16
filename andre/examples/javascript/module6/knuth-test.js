// A version of Donald Knuth's ALGOL 60 compiler implementation test

/* ALGOL 60 version
begin
  real procedure A(k, x1, x2, x3, x4, x5);
  value k; integer k;
  real x1, x2, x3, x4, x5;
  begin
    real procedure B;
    begin k := k - 1;
          B := A := A(k, B, x1, x2, x3, x4)
    end;
    if k ≤ 0 then A := x4 + x5 else B
  end;
  outreal(1, A(10, 1, -1, -1, 1, 0))
end
*/

let A = function (k, x1, x2, x3, x4, x5) {
    let B = function() {
        k = k - 1;
        return A(k, B, x1, x2, x3, x4);
    };
    if (k <= 0) {
        return x4() + x5();
    } else {
        return B();
    }
};

console.log(A(10,
    () => 1,
    () => -1,
    () => -1,
    () => 1,
    () => 0));