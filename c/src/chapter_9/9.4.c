#include <stdio.h>

void test1(void);
void test2(void);

int main(void)
{
	int i = 0;
	for (i; i < 5; i++)
	{
		test1();
		test2();	
	}

	return 0;
}

void test1(void)
{
	int count = 0;
	printf("\n test1 count = %d", ++count);	
}

void test2(void)
{
	static int count = 0;
	printf("\n test2 count = %d", ++count);	
}
