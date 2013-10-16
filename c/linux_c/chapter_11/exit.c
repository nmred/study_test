#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <errno.h>

int main(void)
{
	int fd;
	if ((fd = open("no_such_a_file", O_RDWR)) == -1) {
		printf("fail to open file\n");
		exit(errno);	
	}	

	return 0;
}
