#include <stdio.h>

int main(void)
{
	char ch[] = {'h', 'e', 'l', 'l', 'o', '\0'};
	
	printf("%s\n", ch);
	ch[3] = '\0';
	printf("%s\n", ch);

	return 0;
}
