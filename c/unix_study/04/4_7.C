#include "../apue.h"
#include <dirent.h>
#include <limits.h>

typedef int Myfunc(const char *, const struct stat *, int);

static Myfunc myfunc;
static int myftw(char *, Myfunc *);
static int dopath(Myfunc *);

static long nreg, ndir, nblk, nchr, nfifo, nslink, nsock, ntot;

int main(int argc, char *argv[])
{
	int ret;
	if (argc != 2) {
		err_quit("usage: ftw <starting-pathname>");	
	}

	ret = myftw(argv[1], myfunc);

	ntot = nreg + ndir + nblk + nchr + nfifo + nslink + nsock;
	if (ntot == 0) {
		ntot = 1;	
	}

	printf("regular files = %7ld, %5.2d %%\n", nreg, nreg * 100.0 / ntot);
	printf("directories files = %7ld, %5.2d %%\n", ndir, ndir * 100.0 / ntot);
	printf("block special  = %7ld, %5.2d %%\n", nblk, nblk * 100.0 / ntot);
	printf("char special   = %7ld, %5.2d %%\n", nchr, nchr * 100.0 / ntot);
	printf("FIFOs		   = %7ld, %5.2d %%\n", nfifo, nfifo * 100.0 / ntot);
	printf("symbolic links = %7ld, %5.2d %%\n", nslink, nslink * 100.0 / ntot);
	printf("sockets        = %7ld, %5.2d %%\n", nsock, nsock * 100.0 / ntot);

	exit(ret);
}

#define FTW_F 1
#define FTW_D 2
#define FTW_DWR 3
#define FTW_NS 4

static char *fullpath;

static int myftw(char *pathname, Myfunc *func)
{
	int len;
	fullpath = path_alloc(&len);
	
	strncpy(fullpath, pathname, len);
	
	return (dopath(func));
}

static int dopath(Myfunc * func)
{
	struct stat statbuf;
	struct dirent *dirp;
	DIR *dp;	
}
