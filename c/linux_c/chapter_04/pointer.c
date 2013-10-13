#include <stdio.h>

struct test {
	int array[2];
	char ch;	
};

typedef struct test Test;

int main(void)
{
	Test var = {0x123456, 0x12345678, 0x30};
	
	char *p;
	
	p = (char *)&var;
	printf("1 byte: 0x%d\n", *p);	
	p = (short *)p;
	//printf("2 byte: 0x%d\n", *p);	
	//p = (int *)p;
	//printf("2 byte: 0x%d\n", *p);	

	return 0;
}
