#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <ctype.h>
#include <sys/socket.h>
#include <arpa/inet.h>

#define MAX_LINE 100

void my_fun(char *p)
{
	if (p == NULL) {
		return;	
	}

	for (; *p != '\0'; p++) {
		if (*p >= 'A' && *p <= 'Z') {
			*p = *p - 'A' + 'a';	
		}
	}
}

int main(void)
{
	struct sockaddr_in sin;	
	struct sockaddr_in cin;
	int lfd;
	int cfd;
	
	socklen_t len;
	char buf[MAX_LINE];	
	char addr_p[INET_ADDRSTRLEN];
	int port = 8000;
	int n;

	memset(&sin, 0, sizeof(sin));
	sin.sin_family = AF_INET;
	sin.sin_addr.s_addr = INADDR_ANY;
	sin.sin_port = htons(port);

	lfd = socket(AF_INET, SOCK_STREAM, 0);
	bind(lfd, (struct sockaddr *)&sin, sizeof(sin));

	listen(lfd, 10);

	printf("waiting.....\n");

	while(1) {
		cfd = accept(lfd, (struct sockaddr *)&cin, &len);
		
		n = read(cfd, buf, MAX_LINE);
		
		inet_ntop(AF_INET, &cin.sin_addr, addr_p, sizeof(addr_p));
		printf("client IP is %s, port is %d\n", addr_p, ntohs(cin.sin_port));
		printf("content is: %s\n", buf);
		my_fun(buf);

		write(cfd, buf, n);
		close(cfd);
	}

	if (close(lfd) == -1) {
		perror("fail to close");
		exit(1);	
	}

	return 0;
}
