#include <stdio.h>
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
	
	struct horse my_horsers[50];
	int hcount = 0;
	char test = '\0';
	
	for (hcount = 0; hcount < 50; hcount++) {
		printf("\nDo you want to enter details of a%s horse (Y or N)? ", hcount ? "another" : "");
		scanf(" %c", &test);
		if (tolower(test) == 'n') {
			break;	
		}

		printf("\n Enter the name of the horse: ");
		scanf("%s", my_horsers[hcount].name);

		printf("\nHow old is %s?", my_horsers[hcount].name);
		scanf("%d", &my_horsers[hcount].age);

		printf("\nHow high is %s (in hands) ? ", my_horsers[hcount].name);
		scanf("%d", &my_horsers[hcount].height);

		printf("\nWho is %s's father? ", my_horsers[hcount].name);
		scanf("%s", my_horsers[hcount].father);

		printf("\nWho is %s's mother? ", my_horsers[hcount].name);
		scanf("%s", my_horsers[hcount].mother);
	}	

	for (int i = 0; i < hcount; i++) {
		printf("\n\n%s is %d years old, %d hands high,", my_horsers[i].name, my_horsers[i].age, my_horsers[i].height);
		printf(" and has %s and %s as parents.", my_horsers[i].mother, my_horsers[i].father);	
	}

	return 0;
}
