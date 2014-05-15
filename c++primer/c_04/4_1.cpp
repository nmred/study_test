#include <iostream>

using namespace std;
int main(void)
{
	char * firstName = new char[20];
	char * lastName = new char[20];
	int age;
	char grade;
	cout << "What is your first name ?";
	cin.getline(firstName, 20);
	cout << "What is your last name ?";
	cin.getline(lastName, 20);
	cout << "What is your age ?";
	cin >> age;
	cout << "What letter grade to you deserve ?";
	cin >> grade;
	cout << "Name: " <<	firstName << " " << lastName << endl;
	cout << "Grade: " << (char)(grade + 1) << endl;
	cout << "Age: " << age << endl;
	return 0;
}
