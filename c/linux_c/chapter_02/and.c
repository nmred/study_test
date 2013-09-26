#include <stdio.h>

int main(void)
{
	int a = 200;
	int *p = NULL;
	
	p = &a;
	if (p != NULL && *p == 100) {
		printf("hello\n");	
	} else {
		printf("hi\n");	
	}

	return 0;
}
