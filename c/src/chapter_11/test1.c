#include<stdio.h>
#include<string.h>
void main()
{
	int i,rev,n;
	char arr[100];
	gets(arr);
	n=strlen(arr);
	printf("%d", n);
	for(i=0;i<=n/2;i++)
	{
		rev = (arr[i] == arr[n-i]);

		if (!rev) {
			break;	
		}
	}
	printf("%d",rev) ;
	return 0;
}


