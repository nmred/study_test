// teststatic2.c
#include <stdio.h>

static int n; // 定义全局静态变量，自动初始化为0，仅在本文件中可见

void display()
{
	n++;
	printf("%d\n", n);	
}
