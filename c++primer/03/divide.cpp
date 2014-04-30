#include <iostream>

int main()
{
	using namespace std;
	cout.setf(ios_base::fixed, ios_base::floatfield);
	cout << "Integer devision: 9/5 = " << 9/5 << endl;
	cout << "Floating-point dicision: 9.0/5.0 = ";
	cout << 9.0 / 5.0 << endl;
	cout << "Mixed division: 9.0 / 5 = " << 9.0 / 5 << endl;
	cout << "double constants: 1e7f / 9.0f = ";
	cout << 1.e7 / 9.0 << endl;
	cout << "float constants: 1e7f / 9.0f = ";
	cout << 1.e7f / 9.0 << endl;
	return 0;
}
