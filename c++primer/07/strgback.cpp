#include <iostream>

char * buildstr(char c, int n);
int main()
{
	using namespace std;
	int times;
	char ch;
	
	cout << "Enter a character:";
	cin >> ch;
	cout << "Enter an integer:";
	cin >> times;
	char *ps = buildstr(ch, times);
	cout << ps << endl;
	
	delete [] ps;
	ps = buildstr('+', 20);
	cout << ps << "-DONE-" << ps << endl;
	delete [] ps;
	return 0;
}

char * buildstr(char c, int n)
{
	char *pchar = new char[n + 1];
	pchar[n] = '\0';
	while(n-- > 0) {
		pchar[n] = c;	
	}	

	return pchar;
}
