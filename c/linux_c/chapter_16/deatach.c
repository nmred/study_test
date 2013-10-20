#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *tfn1(void * arg)
{
	printf("the pthread\n");
	
	sleep(5);
	
	printf("the thread done\n");
	
	return NULL;	
}

int main(void)
{
	int err;
	pthread_t tid;
	
	err = pthread_create(&tid, NULL, tfn1, NULL);
	if (err != 0) {
		printf("can't create thread %s\n", strerror(err));
		exit(1);	
	}	

	err = pthread_detach(tid);
	if (err != 0) {
		printf("can't detach thread %s\n", strerror(err));
		exit(1);	
	}

	err = pthread_join(tid, NULL);
	if (err != 0) {
		printf("thread has been detached\n");	
	}

	sleep(5);
	printf("the main thread done\n");

	return 0;
}
