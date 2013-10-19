#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <limits.h>

#define BUFES 1024

int main(void)
{
	FILE *fp;
	char *cmd = "cat file1";
	char buf[BUFES];
	
	if ((fp = popen(cmd, "r")) == NULL) {
		perror("failed to popen");
		exit(1);	
	}

	while((fgets(buf, BUFES, fp)) != NULL) {
		printf("%s", buf);	
	}

	pclose(fp);
	exit(0);
}
