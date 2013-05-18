#include <stdio.h>
#include "b.h"

int print(char *str, A_class post)
{
	printf("%s:(%d,%d,%d)\n", str, post.x, post.y, post.z);
	return 0;
}
