#include <stdio.h>
#include <stdlib.h>

extern int (*p1)(int, int);
extern int (*p2)(int, int);
extern int (*p3)(int, int);
extern int (*p4)(int, int);

int add(int a, int b);
int sub(int a, int b);
int mul(int a, int b);
int div1(int a, int b);
