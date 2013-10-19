#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdlib.h>
#include <stdio.h>

#define BUFSZ 4096

int main(void)
{
	int shm_id;
	
	shm_id = shmget(IPC_PRIVATE, BUFSZ, 0666);
	if (shm_id < 0) {
		perror("shmget");
		exit(1);	
	}	

	printf("successfully created segment: %d\n", shm_id);
	system("ipcs -m");
	exit(0);
}
