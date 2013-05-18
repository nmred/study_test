#include <stdio.h>
#include "b.h"

int main(int argc, char *argv[])
{
	int x = 10, y = 5;
	printf("x = 10, y = 5\n");
	printf("x + y = %d\n", add(x, y));
	printf("x - y = %d\n", sub(x, y));
	printf("x * y = %d\n", mult(x, y));
	printf("x / y = %d\n", div(x, y));
	return 0;
}
