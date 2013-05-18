#include <stdio.h>

int max(int x, int y); // 函数提前声明
int main(int argc, char *argv[])
{
	int result;
	extern int X;
	extern int Y;
	result = max(X, Y);
	printf("the max value is %d\n", result);
	return 0;
}

int X = 10; //定义外部变量
int Y = 20;

int max(int x, int y)
{
	return (x > y ? x : y);	
}
