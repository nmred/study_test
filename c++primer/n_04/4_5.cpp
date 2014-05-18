#include <iostream>

struct CandyBar {
	char * name;
	double weight;
	int number;
};

int main(void)
{
	using namespace std;
	CandyBar snack = {
		"Mocha Munch",
		2.3,
		350	
	};	

	cout << "name:" << snack.name << endl;
	cout << "weight:" << snack.weight << endl;
	cout << "number:" << snack.number << endl;
	return 0;
}
