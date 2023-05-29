/* D sum program */

import std.stdio;

private int sum(int[] seq) {
  int s;
  foreach (int v; seq)
    s+=v;
  return s;
}

void main() {
  int[] seq=[5,6,1,8,3,7];
  writeln(sum(seq));
}
