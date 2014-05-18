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
	snap = new CandyBar;
	snap->name = new char[MAX_NAME]; 
//
	cout << "input name:";
	cin.getline(snap->name, MAX_NAME);
	cout << "input raduis:";
	cin >> snap->raduis;
	cout << "input weight:";
	cin >> snap->weight;

	cout << "name:" << snap->name << " raduis: " << snap->raduis << " weight: " << snap->weight << endl;
	delete snap;
	return 0;
}
