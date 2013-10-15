#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void)
{
	pid_t pid;
	pid = fork();
	
	if (pid < 0) {
		printf("fail to fork\n");
		exit(1);	
	} else if (pid == 0) {
		printf("this is child, pid is: %u\n", getpid());	
	} else {
		printf("this is parent, pid is: %u, child-pid is : %u\n", getpid(), pid);	
	}

	return 0;
}
