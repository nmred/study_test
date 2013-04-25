/* 动态链接库测试 */

#ifndef __DATETIME_H

#define __DATETIME_H

typedef struct
{
	int year;
	int mon;
	int day;	
} DATETYPE;

typedef struct
{
	char hour;
	char min;
	char sec;
} TIMETYPE;

#ifdef SHARED
int (*getdate)(DATETYPE *d);
#else
int getdate(DATETYPE *d);
#endif

#ifdef SHARED
int (*gettime)(TIMETYPE *t);
#else
int gettime(TIMETYPE *t);
#endif

#endif
