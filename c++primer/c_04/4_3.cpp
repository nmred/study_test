#include <iostream>
#include <cstring>

const int CHAR_SIZE = 20;

int main(void)
{
	using namespace std;
	char *firstName = new char[CHAR_SIZE];	
	char *lastName = new char[CHAR_SIZE];
		
	cout << "Enter your first name:";
	cin.getline(firstName, CHAR_SIZE);
	cout << "Enter your last name:";
	cin.getline(lastName, CHAR_SIZE);
	strcat(firstName, lastName);
	
	cout << "Name:" << firstName << endl;
	return 0;
}
