#include <stdio.h>

int main(void)
{
	printf("int : %d\n", sizeof(int));
	printf("short : %d\n", sizeof(short));
	printf("char : %d\n", sizeof(char));
	printf("unsigned int : %d\n", sizeof(unsigned int));
	printf("long : %d\n", sizeof(long));

	printf("long long: %d\n", sizeof(long long));
	printf("float : %d\n", sizeof(float));
	printf("double : %d\n", sizeof(double));
	printf("long double : %d\n", sizeof(long double));

	return 0;
}
