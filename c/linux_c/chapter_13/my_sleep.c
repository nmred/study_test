#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/time.h>
#include <time.h>
#include <signal.h>

void sigalrm_handler(int signo)
{
	// SIGALRM 处理函数什么都不做，只是替换掉默认的终结进程的操作	
}

void sigusr1_handler(int signo)
{
	printf("catch SIGUSR1\n");	
}

unsigned int my_sleep(unsigned int nsec)
{
	void (*p)(int) = SIG_IGN;	

	if ((p = signal(SIGALRM, sigalrm_handler)) == SIG_ERR) {
		perror("can't set handler for SIGALRM");
		exit(1);	
	}

	alarm(nsec);
	pause();
	if (signal(SIGALRM, p) == SIG_ERR) {
		perror("can't rescue handler for SIGALRM");
		exit(1);	
	}

	return alarm(0);
}

int main(void)
{
	struct timeval begintime, endtime;
	float elapsed;
	unsigned int rest;
	
	// 设置 SIGUSR1 的信号处理函数，不设置的话 SIGUSR1 信号不能从 pause 函数中唤醒进程
	if (signal(SIGUSR1, sigusr1_handler) == SIG_ERR) {
		perror("can't set handler for SIGUSR1");
		exit(1);	
	}

	printf("the first time\n");
	printf("before sleeping\n");

	gettimeofday(&begintime, NULL);
	
	my_sleep(10);

	printf("after sleep\n");

	gettimeofday(&endtime, NULL);

	elapsed = 1000000 * (endtime.tv_sec - begintime.tv_sec) + endtime.tv_usec - begintime.tv_usec;
	elapsed /= 1000000;

	printf("elapsed time is %f\n", elapsed);

	printf("the second time \n");
	printf("before sleeping\n");

	gettimeofday(&begintime, NULL);
	
	rest = my_sleep(20);

	printf("after sleep\n");

	gettimeofday(&endtime, NULL);

	elapsed = 1000000 * (endtime.tv_sec - begintime.tv_sec) + endtime.tv_usec - begintime.tv_usec;
	elapsed /= 1000000;

	printf("actual sleeping-time is %f\n", elapsed);
	printf("the rest is %u\n", rest);

	return 0;
}
