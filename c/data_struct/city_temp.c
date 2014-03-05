#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node {
	char * City;
	int Temp;
	struct Node *Next;	
};

typedef struct Node * Link;
Link Head;
int NodeCount;

int AddNodeAscend(Link);
int DuplicateNode(Link, Link);
void FreeNode(Link);
int NodeCmp(Link, Link);
void CreateList(void);
int DeleteNode(Link);
void ShowNodes(void);

/**
 *  {{{ 添加节点 
 */
int AddNodeAscend(Link to_add)
{
	Link pn, prev, curr;
	struct Node dummy;
	int i;
	
	pn = (Link) malloc(sizeof(struct Node));
	if (pn == NULL) {
		return 0;	
	}

	memcpy(pn, to_add, sizeof(struct Node));

	// 设置虚拟节点
	dummy.Next = Head;
	prev = &dummy;
	curr = Head;

	for (;; prev = curr, curr = curr->Next) {
		if (curr == NULL) { // 到达了链表的结尾
			break;
		}

		i = NodeCmp(pn, curr);
		if (i <= 0) {
			break;	
		}
	}

	if (curr && i == 0) {
		if (DuplicateNode(curr, pn) == 0) {
			return 1;			
		}
	}

	prev->Next = pn;
	pn->Next = curr;

	Head = dummy.Next; // 回收虚拟节点
	return 1;
}

// }}}
 
/**
 *  {{{ 删除重复节点 
 */
int DuplicateNode(Link inlist, Link duplicate)
{
	FreeNode(duplicate);
	return 0;
}

 // }}}
 
/**
 *  {{{ 释放内存 
 */
void FreeNode(Link n)
{
	free(n->City);
	free(n);
}

 // }}}
 
/**
 *  {{{ 比较两个节点的大小 
 */
int NodeCmp(Link a, Link b)
{
	if (a->Temp != b->Temp) {
		return (a->Temp - b->Temp);	
	}

	return strcmp(a->City, b->City);
}

 // }}}
 
/**
 *  {{{ 创建列表 
 */
void CreateList(void)
{
	Head = NULL;
	NodeCount = 0;
}

 // }}}
 
/**
 *  {{{ 删除列表 
 */
int DeleteNode(Link to_delete)
{
	Link curr, prev;
	int i;

	if (Head == NULL) 
		return 0;
	
	for (prev = NULL, curr = Head; curr != NULL && (i = NodeCmp(to_delete, curr)) > 0; prev = curr, curr = curr->Next) {
		// empty loop	
	}

	if (curr != NULL && i == 0) {
		if (prev) {
			prev->Next = curr->Next;	
		} else {
			Head = curr->Next;	
		}

		FreeNode(curr);
		NodeCount -= 1;
		return 1;
	}

	return 0;
}

 // }}}
 
/**
 *  {{{ 显示列表 
 */
void ShowNodes(void)
{
	Link pn;
	int count, median;

	for(count = 0, pn = Head; pn != NULL; pn = pn->Next) {
		count++;	
	}

	median = count / 2 + 1;

	if (count) {
		count = 0;
		for (pn = Head; pn; pn = pn->Next) {
			printf("%-20s: %3d", pn->City, pn->Temp);
			count += 1;
			if (count == median) {
				printf(" -- Median --");	
			}
			printf("\n");
		}
	} else {
		printf("Empty list\n");	
	}
}

 // }}}
 
/**
 *  {{{ main 
 */
int main(int argc, char *argv[])
{
	FILE *fin;
	char buffer[128];

	struct Node n;

	if (argc != 2) {
		fprintf(stderr, "Usage: citytemp filename.ext\n");
		exit(EXIT_FAILURE);	
	}

	fin = fopen(argv[1], "r");
	if (fin == NULL) {
		fprintf(stderr, "Cannot open/find %s\n", argv[2]);
		exit(EXIT_FAILURE);	
	}

	CreateList();

	while(!feof(fin)) {
		if (fgets(buffer, 127, fin) == NULL) {
			break;	
		}

		buffer[strlen(buffer) -1] = '\0';
		n.City = strdup(buffer + 3);
		buffer[3] = '\0';
		n.Temp = atoi(buffer);
		if (AddNodeAscend(&n) == 0) {
			fprintf(stderr, "Error adding node. Aborting\n");
			exit(EXIT_FAILURE);	
		}
	}

	ShowNodes();

	return 0;
}

 // }}}
