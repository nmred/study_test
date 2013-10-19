#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

void sigusr1_handler(int signo)
{
	printf("catch SIGUSR1\n");
	
	sleep(5);
	
	printf("back to main\n");	
}

int main(void)
{
	struct sigaction act;
	
	act.sa_handler = sigusr1_handler;
	act.sa_flags = SA_NODEFER;
	act.sa_sigaction = NULL;
	
	sigemptyset(&act.sa_mask);
	
	if (sigaction(SIGUSR1, &act, NULL) == -1) {
		perror("fail to set handler for SIGCHLD");
		exit(1);	
	}	

	printf("process begin\n");

	sleep(10);

	printf("done\n");

	return 0;
}
