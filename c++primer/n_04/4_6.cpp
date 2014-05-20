#include <iostream>

struct CandyBar {
	char * name;
	double weight;
	int number;
};

int main(void)
{
	using namespace std;
	CandyBar snack[3] = { 
		{
			"Mocha Munch",
			2.3,
			350
		},
		{
			"Mocha Munch",
			2.3,
			350
		},
		{
			"Mocha Munch",
			2.3,
			350
		}
	};	

	cout << "name:" << snack[0].name << endl;
	cout << "weight:" << snack[0].weight << endl;
	cout << "number:" << snack[0].number << endl;
	return 0;
}
