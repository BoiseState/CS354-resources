#include <stdio.h> 

struct Person {
    int age;
    char name[10];
};

//doesn't work
void increment_age(struct Person p) 
{
    p.age = p.age + 1;
}

//try this!
void inc_age_pointer(struct Person *p)
{
    (*p).age = (*p).age + 1;
}

//best!
void inc_age_pointer_2(struct Person *p) 
{
    p->age = p->age + 1;
}


int main()
{
    struct Person person = {40, "myname!"};

    increment_age(person);

    printf("%d\n", person.age);

    inc_age_pointer(&person);

    printf("%d\n", person.age);
    
    inc_age_pointer_2(&person);
    
    printf("%d\n", person.age);

    return 0;
}
