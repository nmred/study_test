// teststatic1.c
#include <stdio.h>
void display();
extern int n;
int main()
{
	n = 20;
	printf("%d\n", n);
	display();
	return 0;
}
