#include <stdio.h>

int main(void)
{
	int n;
	int mul = 1;
	int i = 1;
	
	scanf("%d", &n);
	
loop:
	mul *= i;
	i++;
	if (i <= n) {
		goto loop;	
	}

	printf("the result is %d\n", mul);

	return 0;
}
