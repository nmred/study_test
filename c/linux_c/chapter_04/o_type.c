#include <stdio.h>

struct test {
	int a;
	int b;
	int c;	
};

int main(void)
{
	int a[10];
	int *p;
	struct test var;
	
	printf("array : %d\n", sizeof(a));
	printf("pointer: %d\n", sizeof(p));
	printf("struct : %d\n", sizeof(var));	

	return 0;
}
