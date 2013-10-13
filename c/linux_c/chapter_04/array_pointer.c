#include <stdio.h>

int main(void)
{
	int a[5] = {1, 2, 3, 4, 5};
	int (*p)[5];
	int *ptr;
	
	p = &a;
	ptr = (int *)(p + 1); // 强制转化数组类型
	printf("the result is : %d", *(ptr -1));
	
	return 0;	
}
