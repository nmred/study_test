#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int *p;
	p = malloc(sizeof(int));
	if (p == NULL) {
		perror("fail to malloc");	
		exit(1);
	}

	p = (int *)p;
	*p = 100;
	printf("the value is :%d\n", *p);

	return 0;
}
