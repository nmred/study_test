#include <iostream>

const int Max = 5;

int fill_array(double ar[], int limit);
void show_array(const double ar[], int n);
void revalue(double r, double ar[], int n);

int main()
{
	using namespace std;
	double properties[Max];
	
	int size = fill_array(properties, Max);
	show_array(properties, size);
	cout << "Enter revaluation factor: ";
	double factor;
	cin >> factor;
	revalue(factor, properties, size);
	show_array(properties, size);
	cout << "Done.\n";
	return 0;	
}

int fill_array(double arr[], int limit)
{
	using namespace std;
	double temp;
	int i;
	for (i = 0; i < limit; i++) {
		cout << "Enter value#" << (i + 1) << ":";
		cin >> temp;
		if (!cin) {
			cin.clear();
			while(cin.get() != '\n') {
				continue;
			}
			cout << "Bad input: input process terminated.\n";	
			break;
		} else if (temp < 0) {
			break;
		} else {
			arr[i] = temp;	
		}
	}

	return i;
}

void show_array(const double arr[], int n)
{
	using namespace std;
	for (int i = 0; i < n; i++) {
		cout << "Property #" << (i + 1) << ":$ ";
		cout << arr[i] << endl;	
	}
}

void revalue(double r, double arr[], int n)
{
	for (int i = 0; i < n; i++) {
		arr[i] *= r;
	}	
}
