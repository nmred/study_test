#include <stdio.h>

int main(void)
{
	int n;
	int mul = 1;
	int i = 1;
	
	scanf("%d", &n);
	do {
		mul *= i;
		i++;	
	} while(i <= n);

	printf("the result is %d \n", mul);

	return 0;
}
