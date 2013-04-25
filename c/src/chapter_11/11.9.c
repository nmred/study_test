#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define PAGE_HEIGHT 20
#define PAGE_WIDTH 40

typedef struct barTAG
{
	double value;
	struct barTAG *pnextbar;	
} bar;

typedef unsigned int uint;

int bar_chart(bar *pfirstbar, uint page_width, uint page_height, char *title);

// {{{ main()

int main(void)
{
	bar firstbar;
	bar *plastbar = NULL;
	char value[80];
	char title[80];
	
	printf("\nEnter the chart title:");
	fgets(title, sizeof(title), stdin);
	for(;;) {
		printf("Enter the value of the bar, or use quit to end:");
		fgets(value, sizeof(value), stdin);
		if (strcmp(value, "quit") == 1) {
			break;	
		}

		if (!plastbar) {
			firstbar.pnextbar = NULL;
			plastbar = &firstbar;	
		} else {
			if (!(plastbar->pnextbar = malloc(sizeof(bar)))) {
				printf("Oops! Couldn's allocate memory\n");
				return -1;	
			}
			plastbar = plastbar->pnextbar;
			plastbar->pnextbar = NULL;
		}

		plastbar->value = atof(value);
	}

	bar_chart(&firstbar, PAGE_WIDTH, PAGE_HEIGHT, title);

	while(firstbar.pnextbar) {
		plastbar = firstbar.pnextbar;
		firstbar.pnextbar = plastbar->pnextbar;
		free(plastbar);	
	}

	return 0;
}

// }}}
// {{{ bar_chart()
int bar_chart(bar *pfirstbar, uint page_width, uint page_height, char *title)
{
	bar *plastbar = pfirstbar;
	double max = 0.0;
	double min = 0.0;
	double vert_scale = 0.0;
	double position = 0.0;
	uint bar_count = 1;
	uint barwidth = 0;
	uint space = 2;
	uint i = 0;
	uint bars = 0;
	char *column = NULL;
	char *blank = NULL;
	bool axis = false;
	
	max = min = plastbar->value;
	
	while((plastbar = plastbar->pnextbar) != NULL) {
		bar_count++;
		max = (max < plastbar->value) ? plastbar->value : max;
		min = (min > plastbar->value) ? plastbar->value : min;
	}

	vert_scale = (max - min) / page_height;

	if ((barwidth = page_width / bar_count - space) < 1) {
		printf("\n Page width too narrow.\n");
		return -1;
	}

	if ((column = malloc(barwidth + space + 1)) == NULL) {
		printf("\nFailed to allocate memory in barchart() - terminating program.\n");
		exit(1);	
	}

	for (i = 0; i < space; i++) 
	{
		*(column + i) = ' ';	
	}

	for (; i< space + barwidth; i++) {
		*(column + i) = '#';
	}
	*(column + i) = '\0';	

	if ((blank = malloc(barwidth + space + 1)) == NULL) {
		printf("\nFailed to allocate memory in barchart() - terminating program.\n");
		exit(1);	
	}

	for (i = 0; i < space + barwidth; i++) 
	{
		*(blank + i) = ' ';	
	}
	*(blank + i) = '\0';	

	printf("^ %s\n", title);
	position = max;
	for (i = 0; i < page_height; i++) 
	{
		if (position <= 0.0 && !axis) {
			printf("+");
			for(bars = 0; bars < bar_count * (barwidth + space); bars++) {
				printf("-");
			}
			printf(">\n");
			axis = true;
			position -= vert_scale;
			continue;
		}
		printf("|");
		plastbar  = pfirstbar;
		for (bars = 1; bars <= bar_count; bars++) 
		{
			printf("%s", ((position <= plastbar->value && position > 0.0 && plastbar->value >= 0) 
						 || position >= plastbar->value && position <= 0.0 && plastbar->value <= 0) ? column : blank);
			plastbar = plastbar->pnextbar;
		}
		printf("\n");
		position -= vert_scale;
	}

	if (!axis) {
		printf("+");
		for (bars = 0; bars < bar_count * (barwidth + space); bars++) 
		{
			printf("-");	
		}	
		printf(">\n");
	}

	free(column);
	free(blank);
}
// }}}
