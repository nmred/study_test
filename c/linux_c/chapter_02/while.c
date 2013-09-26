#include <stdio.h>

int main(void)
{
	int n;
	long mul = 1L;
	long i = 1L;
	
	scanf("%d", &n);
	
	while (i <= n) {
		mul *= i;
		i++;	
	}

	printf("the result is %ld\n", mul);

	return 0;
}
