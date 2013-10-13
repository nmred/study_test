#include <stdio.h>

int add(int a, int b)
{
	return a + b;	
}

int mul(int a, int b)
{
	return a * b;	
}

int main(void)
{
	int (*op[2])(int a, int b);
	
	op[0] = add;
	op[1] = mul;
	
	printf("%d %d\n", op[0](1, 2), op[1](1, 2));
	
	return 0;	
}
