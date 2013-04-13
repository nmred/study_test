#include <stdio.h>

int main(int argc, char *argv[])
{
	printf("program name: %s\n", argv[0]);	
	int i = 1;
	for(i; i < argc; i++) {
		printf("\n Argument %d: %s", i, argv[i]);	
	}
	return 0;
}
