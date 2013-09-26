#include <stdio.h>

int main(void)
{
	int n;
	int add = 0;
	int i = 1;
	
	scanf("%d", &n);
	
	if (i > n) {
		goto done;	
	}

loop:
	add += i;
	i++;
	if (i <= n) {
		goto loop;	
	}

done:
	printf("the result is %d\n", add);
	return 0;
}
