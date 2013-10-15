#include <stdio.h>
#include <unistd.h>

int main()
{
	pid_t pid, ppid, uid, euid, gid, egid;
	
	pid = getpid();
	ppid = getppid();
	uid = getuid();
	euid = geteuid();
	gid = getgid();
	egid = getegid();
	
	printf("id of current process: %u\n", pid);	
	printf("parent id of current process: %u\n", ppid);	
	printf("effective user id of current process: %u\n", euid);	
	printf("group  id of current process: %u\n", gid);	
	printf("effective group id of current process: %u\n", egid);	

	return 0;
}
