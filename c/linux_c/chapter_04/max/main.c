#include "common.h"

#define MAX 3

int main(void)
{
	Book array1[MAX];
	int *array[MAX];
	
	int i;
	int id;
	int val;
	char name[10];
	Book res1;
	int *res2;
	
	for (i = 0; i < MAX; i++) {
		printf("input info of book\n");
		scanf("%d", &id);
		scanf("%s", name);
		if (insert_struct((array1 + i), id, name) == -1) {
			exit(1);	
		}

		printf("input int\n");
		scanf("%d", &val);
		if (insert_int((array + i), val) == -1) {
			exit(1);	
		}
	}
	
	res1 = (Book)max((void *)array1, MAX, cmp_struct);
	res2 = (int *)max((void *)array, MAX, cmp_int);

	printf("the max of books: %d, %s\n", res1->id, res1->name);
	printf("the max of int: %d\n", *res2);

	return 0;
}
