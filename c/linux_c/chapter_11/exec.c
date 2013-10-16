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
		if (execvp("./pid.c.o", NULL) < 0) {
			printf("fail to exec\n");
			exit(0);	
		}

		// 这里应该永远不会执行，因为调用 exec 后这里的代码被 pid.c.o 程序取代了
		printf("the child is not pid.c.o");
		exit(0);
	}

	printf("the parent\n");

	return 0;
}
