#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(void)
{
	struct horse {
		int age;
		int height;
		char name[20];
		char father[20];
		char mother[20];	
	};
	
	struct horse *phorse[50];
	int hcount = 0;
	char test = '\0';
	
	for (hcount = 0; hcount < 50; hcount++) {
		printf("\nDo you want to enter details of a%s horse (Y or N)? ", hcount ? "another" : "");
		scanf(" %c", &test);
		if (tolower(test) == 'n') {
			break;	
		}

		phorse[hcount] = (struct horse *) malloc(sizeof(struct horse));

		printf("\n Enter the name of the horse: ");
		scanf("%s", phorse[hcount]->name);

		printf("\nHow old is %s?", phorse[hcount]->name);
		scanf("%d", &phorse[hcount]->age);

		printf("\nHow high is %s (in hands) ? ", phorse[hcount]->name);
		scanf("%d", &phorse[hcount]->height);

		printf("\nWho is %s's father? ", phorse[hcount]->name);
		scanf("%s", phorse[hcount]->father);

		printf("\nWho is %s's mother? ", phorse[hcount]->name);
		scanf("%s", phorse[hcount]->mother);
	}	

	for (int i = 0; i < hcount; i++) {
		printf("\n\n%s is %d years old, %d hands high,", phorse[i]->name, phorse[i]->age, phorse[i]->height);
		printf(" and has %s and %s as parents.", phorse[i]->mother, phorse[i]->father);	
		free(phorse[i]);
	}

	return 0;
}
