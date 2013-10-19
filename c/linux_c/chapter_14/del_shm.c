#include <stdio.h>
#include <stdlib.h>
#include <sys/shm.h>

int main(int argc, char *argv[])
{
	int shm_id;

	if (argc != 2) {
		printf("USAGE: del_shm <shm_id>");
		exit(1);	
	}

	shm_id = atoi(argv[1]);
	if (shmctl(shm_id, IPC_RMID, NULL) < 0) {
		perror("rm shm");
		exit(1);
	}

	system("ipcs -m");
}
