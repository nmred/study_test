#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

#define NAME_MAX 20;

struct
{
	char *filename;
	FILE *pfile;	
} global = {
	'test.aa',
	NULL	
};

struct Date
{
	int day;
	int month;
	int year;		
};

typedef struct family
{
	struct Date dob;
	char name[NAME_MAX];
	char pa_name[NAME_MAX];
	char ma_name[NAME_MAX];
} Family;

bool get_person(Family *pfamily);
void getname(char *name);
void show_person_data(void);
void get_parent_dob(Family *pfamily);

// {{{ main()

int main(void)
{
	Family member;
	
	if (!(global.pfile = fopen(global.filename, "wb"))) {
		printf("\nUnable to open %s for writing.\n", global.filename);
		exit(1);	
	}

	while(get_person(&member)) {
		fwrite(&member, sizeof member, 1, pfile);	
	}
	fclose(global.pfile);

	show_person_data();
	if (remove(global.filename)) {
		printf("\nUnable to delete %s.\n", global.filename);	
	} else {
		printf("\nDeleted %s OK.\n", global.filename);	
	}

	return 0;
}

// }}}
// {{{ get_person()

bool get_person(Family *temp)
{
	static char more = '\0';
	printf("\nDo you want to enter details of a%s person (Y or N)?", more != '\0' ? "nother" : "");
	scanf(" %c", &more);
	
	if (tolower(more) == 'n') {
		return false;	
	}	

	printf("\nEnter the name of the person: ");
	getname(temp->name);
	printf("\nEnter %s's date of birth (day month year);", temp->name);
	scanf("%d %d %d", &temp->dob.day, &temp->dob.month, &temp->dob.year);

	printf("\nWho id %s's father?", temp->name);
	getname(temp->pa_name);
	printf("\nWho id %s's mother?", temp->name);
	getname(temp->ma_name);
	return true;
}

// }}} 
