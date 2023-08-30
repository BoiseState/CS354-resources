# Python sum program

def sum(seq):
    s=0
    for v in seq:
        s+=v
    return s

seq=[5,6,1,8,3,7]

print(sum(seq))

def sum(seq, n):
    if (n <= 0):
        return 0
    return seq[n - 1] + sum(seq, n - 1)

print(sum(seq, 6))