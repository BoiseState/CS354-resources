// duff's device, see https://en.wikipedia.org/wiki/Duff's_device

// duff's device deals with the possibility that
// there are not a number of bytes to copy divisible by 8
void send(register short *to, register short *from, register int count)
{
    register int n = (count + 7) / 8;
    switch (count % 8) {
    case 0: do { *to = *from++;
    case 7:      *to = *from++;
    case 6:      *to = *from++;
    case 5:      *to = *from++;
    case 4:      *to = *from++;
    case 3:      *to = *from++;
    case 2:      *to = *from++;
    case 1:      *to = *from++;
            } while (--n > 0);
    }
}


// unrolled loop reduces number of runtime checks by factor of 8
void send_og(register short *to, register short *from, register int count)
{
    register int n = count / 8;
    do {
        *to = *from++;
        *to = *from++;
        *to = *from++;
        *to = *from++;
        *to = *from++;
        *to = *from++;
        *to = *from++;
        *to = *from++;
    } while (--n > 0);
}


void send_one_at_a_time(register short *to, register short *from, register int count)
{
    do {
        *to = *from++;
    } while (--count > 0);
}

int main (void) {}