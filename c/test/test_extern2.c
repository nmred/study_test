#include <stdio.h>
int BASE = 2;
extern int exe(int x);

int main(int argc, char *argv[])
{
	int a = 10;
	printf("%d^%d = %d\n", BASE, a, exe(a));
	return 0;	
}
