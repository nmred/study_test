#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

#define MAX 4096

int main(void)
{
	int fd;
	int n = 0;
	char buf[MAX];
	
	if (system("ls > temp.txt") == -1) {
		perror("fail to exec command.");
		exit(1);	
	}
	printf("debug");

	if (fd = open("temp.txt", O_RDWR) == -1) {
		perror("fail to open");
		exit(1);	
	}
	printf("debug");

	printf("%d", fd);
	//if ((n = read(fd, buf, MAX)) == -1) {
	//	perror("fail to read.");
	//	exit(1);	
	//}

	buf[n] = '\0';
	printf("%d, %s", n, buf);
	return 0;
}
