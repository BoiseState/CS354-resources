// gcc -o frames frames.c -g -Wall && ./frames
// gdb ./frames
// GDB:
//     break c
//     run
//     backtrace
//     frame 2
//     print $sp
//     print $fp
//     print &i
//     info args
//     info locals

void d() {}

void c() { /* You are here! */ d(); }

void b(int i) { if (i==0) b(1); else c(); }

void a() { b(0); }

int main(int argc, char *argv[]) { a(); }
