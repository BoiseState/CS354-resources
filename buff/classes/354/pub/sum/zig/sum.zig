// Zig sum program

const std=@import("std");
const stdout=std.io.getStdOut().writer();

pub fn sum(seq: []u32) u32 {
    var s: u32=0;
    for (seq) |v|
        s+=v;
    return s;
}

pub fn main() !void {
    var seq=[_]u32{5,6,1,8,3,7};
    try stdout.print("{d}\n",.{sum(&seq)});
}
