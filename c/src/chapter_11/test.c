#include <stdio.h>
#include <string.h>

int main(void)
{
	char str[] = "key value";
	
	char *p = NULL;
	p = strchr(str, '=');	
	printf("%s", p);
}

