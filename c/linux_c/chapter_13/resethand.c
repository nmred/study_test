#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

void sigusr1_handler(int signo)
{
	printf("catch SIGUSR1\n");	
}

int main(void)
{
	struct sigaction act;
	
	act.sa_handler = sigusr1_handler;
	act.sa_flags = SA_RESETHAND;
	act.sa_sigaction = NULL;
	sigemptyset(&act.sa_mask);

	int rev = -1;

	if ((rev = sigaction(SIGUSR1, &act, NULL)) == -1) {
		perror("fail to set handler for SIGUSR1");
		exit(1);	
	}

	printf("process begin %d\n", rev);

	sleep(5);
	sleep(5);

	printf("done\n");

	return 0;
}
