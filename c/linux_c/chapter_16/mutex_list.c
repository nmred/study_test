#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define MAX_ITEM 3

typedef struct job * Job;

struct job {
	pthread_t tid;
	Job next;
	int val;	
};

pthread_mutex_t q_lock = PTHREAD_MUTEX_INITIALIZER;

int insert(Job *head, int val, pthread_t tid)
{
	Job p, q;
	
	p = *head;
	if (p != NULL) {
		while(p->next != NULL) {
			p = p->next;
		}	
	}

	q = (struct job *)malloc(sizeof(struct job));
	if (q == NULL) {
		perror("fail to malloc");
		return -1;	
	}

	q->next = NULL;
	q->val = val;
	q->tid = tid;

	if (p == NULL) {
		*head = q;
		return 0;	
	}

	p->next = q;

	return 0;
}

void get_job(Job head, Job *task, int *count, pthread_t tid)
{
	Job p, q;

	q = head;
	p = q->next;
	
	while(p != NULL) {
		if (tid == p->tid) {
			q->next = p->next;
			p->next = *task;
			*task = p;
			p = q->next;
			(*count)++;	
		} else {
			q = p;
			p = q->next;	
		}
	}	
}

int free_job(Job *head)
{
	Job q, p;

	for (p = *head; p != NULL; p = p->next) {
		q = p;
		free(q);
	}

	return 0;
}

void print(Job task, pthread_t tid)
{
	Job p;
	
	for (p = task; p != NULL; p = p->next) {
		printf("thread %u: %d\n", tid, p->val);	
	}	
}

void *tfn7 (void * arg)
{
	int count;
	Job task = NULL;
	pthread_t tid;
	
	tid = pthread_self();
	
	count = 0;
	while(count < MAX_ITEM) {
		if (pthread_mutex_trylock(&q_lock) == 0) {
			get_job((Job)arg, &task, &count, tid);
			pthread_mutex_unlock(&q_lock);	
		}
	}

	print((Job)task, tid);

	if (free_job(&task) == -1) {
		exit(1);	
	}

	return (void *)0;
}

int main(void)
{
	Job item;
	pthread_t tid1, tid2;
	int i, err;
	
	item = (Job)malloc(sizeof(struct job));
	
	item->next = NULL;
	item->val = 0;
	item->tid = -1;
	
	if ((err = pthread_create(&tid1, NULL, tfn7, item)) == -1) {
		printf("fail to create thread %s\n", strerror(err));
		exit(0);	
	}
	
	if ((err = pthread_create(&tid2, NULL, tfn7, item)) == -1) {
		printf("fail to create thread %s\n", strerror(err));
		exit(0);	
	}

	printf("==== the 1st put====\n");
	
	pthread_mutex_lock(&q_lock);
	for(i = 0; i< 2; i++) {
		if (insert(&item, i, tid1) == -1) {
			exit(1);	
		}	
		if (insert(&item, i + 1, tid2) == -1) {
			exit(1);	
		}	
	}

	if (insert(&item, 10, tid1) == -1) {
		exit(1);	
	}

	pthread_mutex_unlock(&q_lock);

	sleep(5);

	printf("=== the 2nd put =====\n");
	pthread_mutex_lock(&q_lock);
	if (insert(&item, 9, tid2) == -1) {
		exit(1);	
	}

	pthread_mutex_unlock(&q_lock);
	
	err = pthread_join(tid1, NULL);
	if (err != 0) {
		printf("can't join thread %s\n", strerror(err));
		exit(1);	
	}
	
	err = pthread_join(tid2, NULL);
	if (err != 0) {
		printf("can't join thread %s\n", strerror(err));
		exit(1);	
	}

	printf("main thread done\n");

	if (item->next == NULL) {
		printf("No job in the queue\n");	
	}

	free(item);

	return 0;
}
