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
		printf("the child\n");
		pid = fork();
		if (pid < 0) {
			printf("fail to fork\n");
			exit(1);	
		} else if (pid == 0) { // 孙进程
			printf("do something you want\n");
			sleep(5);
			printf("done\n");
			exit(0);
		} else { // 子进程退出，孙进程由 init 接管
			exit(0);	
		}
	} else {
		printf("the parent\n");	
	}

	return 0;
}
