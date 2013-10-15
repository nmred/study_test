#include <stdio.h>
#include <string.h>

char *basename(char * full_name)
{
	char *p;
	
	p = rindex(full_name, '/');
	
	if (p == NULL) {
		p = full_name;	
	} else {
		p++;	
	}

	return p;
}

int main(int argc, char *argv[])
{
	char *p;
	p = basename(argv[0]);
	printf("file name is : %s\n", p);
	
	return 0;	
}
