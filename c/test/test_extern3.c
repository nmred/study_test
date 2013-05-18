#include <stdio.h>
extern BASE;
int exe(int x)
{
	int i;
	int ret = 1;
	for (i = 0; i < x; i++) {
		ret *= BASE;	
	}

	return ret;
}
