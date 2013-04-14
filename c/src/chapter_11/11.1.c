#include <stdio.h>

int main(void)
{
	struct horse {
		int age;
		int height;
		char name[20];
		char father[20];
		char mother[20];	
	};

	struct horse my_first_horse;

	printf("Enter the name of the horse: ");
	scanf("%s", my_first_horse.name);

	printf("How old is %s?", my_first_horse.name);
	scanf("%d", &my_first_horse.age);

	printf("How high is %s (in hands) ? ", my_first_horse.name);
	scanf("%d", &my_first_horse.height);

	printf("Who is %s's mother?", my_first_horse.name);
	scanf("%s", my_first_horse.mother);

	printf("Who is %s's father?", my_first_horse.name);
	scanf("%s", my_first_horse.father);
	
	printf("\n%s is %d years old, %d hands high,", my_first_horse.name, my_first_horse.age, my_first_horse.height);
	printf(" and has %s and %s as parents.\n", my_first_horse.mother, my_first_horse.father);

	return 0;
}
