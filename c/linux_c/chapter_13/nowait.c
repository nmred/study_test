#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <errno.h>

int main(void)
{
	struct sigaction act;
	pid_t pid;
	
	/* 设置 sigaction 结构
	 * sa_handler : 采用默认的信号处理方式
	 * sa_mask : 不屏蔽任何信号
	 * sa_flags : 使用 SA_NOCLDWAIT 信号选项
	 * sa_sigaction : 不使用备用信号处理函数
	 */
	
	act.sa_handler = SIG_DFL;
	act.sa_flags = SA_NOCLDWAIT;
	act.sa_sigaction = NULL;
	sigemptyset(&act.sa_mask);

	if (sigaction(SIGCHLD, &act, NULL) == -1) {
		perror("fail to set handler for SIGCHILD");
		exit(1);	
	}

	pid = fork();

	if (pid < 0) {
		perror("fail to fork");
		exit(1);	
	} else if (pid == 0) {
		printf("the 1st child\n");
		exit(0);	
	} else {
		pid = fork();
		
		if (pid < 0) {
			perror("fail to fork");
			exit(1);
		} else if (pid == 0) {
			printf("the 2nd child\n");
			sleep(5);
			exit(0);	
		} else {
			if (wait(NULL) == -1) {
				if (errno == ECHILD) {
					printf("all child quit, no child is zome\n");	
				}
			}

			printf("the parent\n");
		}
	}

	return 0;
}
