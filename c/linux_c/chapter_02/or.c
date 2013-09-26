#include <stdio.h>

int main(void)
{
	int a = 200;
	int *p = NULL;
	
	p = &a;
	if (p == NULL || *p != 100) {
		printf("hi\n");	
	} else {
		printf("hello\n");	
	}

	return 0;
}
