#include <stdio.h>

int add(int x, int y)
{
	return (x + y);	
}

int sub(int x, int y)
{
	return x - y;	
}

int mult(int x, int y)
{
	return x * y;	
}

int div(int x, int y)
{
	if (y != 0)	{
		return (x / y);
	}

	printf("mult()fail second para can not be zero!\n");
	return -1;
}
