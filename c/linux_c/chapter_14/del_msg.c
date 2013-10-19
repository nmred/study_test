#include <sys/msg.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int qid;
	if (argc != 2) {
		printf("USAGE: del_msgq <queue ID>");
		exit(1);
	}

	qid = atoi(argv[1]);
	system("ipcs -q");

	if ((msgctl(qid, IPC_RMID, NULL)) < 0) {
		perror("msgctl");
		exit(1);
	}
	system("ipcs -q");
	printf("successfully removed %d queue \n", qid);

	exit(0);
}
