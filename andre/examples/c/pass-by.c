#include <stdio.h> 

struct Person {
    int age;
    char name[10];
};

void inc_age2(struct Person *p);
void inc_age3(struct Person *p);


void increment_age(struct Person p) 
{
    p.age = p.age + 1;
}

int main()
{
    struct Person person = {40, "myname!"};

    increment_age(person);

//    printf("%d\n", person.age);
    inc_age2(&person);

    printf("%d\n", person.age);
    
    inc_age3(&person);
    
    //printf("%d\n", person.age);
    return 0;
}






void inc_age2(struct Person *p)
{
    (*p).age = (*p).age + 1;
}

void inc_age3(struct Person *p)
{
    p->age = p->age + 1;
}
