#include <iostream>
#include <cstring>

const int MAX_NAME = 20;

struct CandyBar {
	char * name;
	double raduis;
	double weight;	
};
int main(void)
{
	using namespace std;
	CandyBar * snap;
	snap = new CandyBar[3];
//
	for (int i = 0; i < 3; i++) {
		snap[i].name = new char[MAX_NAME]; 
		cout << "input name:";
		cin.getline(snap[i].name, MAX_NAME);
		cout << "input raduis:";
		cin >> snap[i].raduis;
		cout << "input weight:";
		cin >> snap[i].weight;

		cout << "name:" << snap[i].name << " raduis: " << snap[i].raduis << " weight: " << snap[i].weight << endl;
		cin.get();
		delete [] snap[i].name;
	}
	delete [] snap;
	return 0;
}
