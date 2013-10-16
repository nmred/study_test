#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void)
{
	pid_t pid;
	int status;
	int *p;
	
	pid = fork();
	if (pid < 0) {
		perror("fail to fork");
		exit(1);	
	} else if (pid == 0) {
		printf("the first, exit normally\n");
		exit(0);	
	} else {
		if (wait(&status) == -1) {
			perror("fail to wait");
			exit(1);	
		}	

		if (WIFEXITED(status) == 1) {
			printf("the status of first is : %d\n", WEXITSTATUS(status));
		}

		pid = fork();
		if (pid < 0) {
			perror("fail to fork");
			exit(1);	
		} else if (pid == 0) {
			printf("the second, exit abnormally\n");
			*p = 'A'; // 内存访问异常,段错误	
		} else {
			if (wait(&status) == -1) {
				perror("fail to wait");
				exit(1);	
			}	

			if (WIFSIGNALED(status) == 1) {
				printf("the status of second is : %d\n", WTERMSIG(status));
			}

		}
	}

	return 0;
}
