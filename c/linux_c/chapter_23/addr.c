#include <stdio.h>
#include <stdlib.h>
#include <netinet/in.h>

int main(void)
{
	char addr_p[16];
	struct in_addr addr_n;
	
	if (inet_pton(AF_INET, "192.168.11.1", &addr_n) != 1) {
		perror("fail to convert");
		exit(1);	
	}

	printf("address: %x\n", addr_n);

	int rev = 1;

	if (!(rev = inet_ntop(AF_INET, &addr_n, addr_p, sizeof(addr_p)))) {
		printf("fail to convert %d", rev);
//		exit(1);	
	}

	printf("address: %s\n", addr_p);

	return 0;
}
