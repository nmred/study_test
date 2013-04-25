#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MEM_PRIMES  100

int test_prime(unsigned long long N);
void put_primes(void);
int check(unsigned long long buffer[], size_t count, unsigned long long N);


struct
{
	char *filename;
	FILE *pfile;
	int nrec;
	unsigned long long primes[MEM_PRIMES];
	size_t index;
} global = {
	"test.aaa",
	NULL,
	0,
	{2ULL, 3ULL, 5ULL},
	3	
};

// {{{ main()

int main(void)
{
	unsigned long long trial = 5ULL;
	unsigned long long num_primes = 3ULL;
	unsigned long total = 0UL;
	
	printf("How many primes would you like ? ");
	scanf("%lu", &total);
	total = total < 4UL ? 4UL : total;
	
	while (num_primes < total)
	{
		trial += 2UL;
		if (test_prime(trial))
		{
			global.primes[global.index++] = trial;
			num_primes++;
			
			if (global.index == MEM_PRIMES) 
			{
				if (!(global.pfile = fopen(global.filename, "ab")))
				{
					printf("\nUnable to open %s to append\n", global.filename);
					exit(1);	
				}

				fwrite(global.primes, sizeof(unsigned long long), MEM_PRIMES, global.pfile);
				fclose(global.pfile);
				global.index = 0U;
				global.nrec++;
			}
		}
	}

	if (total > MEM_PRIMES)
	{
		put_primes();	
	}

	if (global.index)
	{
		for (size_t i = 0; i < global.index; i++)
		{
			if (i % 5 == 0)
			{
				printf("\n");	
			}
			printf("%12llu", global.primes[i]);
		}
	}

	if (total > MEM_PRIMES)
	{
		if (remove(global.filename)) {
			printf("\nFailed to delete %s\n", global.filename);	
		} else {
			printf("\n File %s deleted .\n", global.filename);
		}
	}

	return 0;
}

// }}}
// {{{ test_prime()

int test_prime(unsigned long long N)
{
	unsigned long long buffer[MEM_PRIMES];
	
	int k = 0;
	if (global.nrec > 0) {
		if (!(global.pfile = fopen(global.filename, "rb"))) {
			printf("\nUnable to open %s to read\n", global.filename);
			exit(1);	
		}

		for (size_t i = 0; i < global.nrec; i++) {
			fread(buffer, sizeof(long long), MEM_PRIMES, global.pfile);
			if ((k = check(buffer, MEM_PRIMES, N)) >= 0) {
				fclose(global.pfile);
				return k;
			}
		}
		fclose(global.pfile);
	}
	
	return check(global.primes, global.index, N);	
}

// }}}
// {{{ check()

int check(unsigned long long buffer[], size_t count, unsigned long long N)
{
	unsigned long long root_N = (unsigned long long)(1.0 + sqrt(N));

	for (size_t i = 0; i < count; i++) {
		if (N % buffer[i] == 0ULL) {
			return 0;	
		}

		if (buffer[i] > root_N) {
			return 1;	
		}
	}
}

// }}}
// {{{ put_primes()

void put_primes(void)
{
	unsigned long long buffer[MEM_PRIMES];
	if (!(global.pfile = fopen(global.filename, "rb"))) {
		printf("\nUnable to open %s to read primes for output\n", global.filename);
		exit(1);
	}

	for (size_t i = 0U; i < global.nrec; i++) {
		fread(buffer, sizeof(unsigned long long), MEM_PRIMES, global.pfile);
		for (size_t j = 0; j < MEM_PRIMES; j++)	{
			if (j % 5 == 0U) {
				printf("\n");
			}

			printf("%12llu", buffer[j]);
		}
	}

	fclose(global.pfile);
}

// }}}
