#include <stdio.h>

struct test {
	char ch;
	short s;
	int i;	
};

int main(void)
{
	struct test var;
	
	printf("size of var: %d\n", sizeof(var));
	
	return 0;	
}
