#include <iostream>

int main()
{
	using namespace std;
	int quizsores[10] = {
		20, 20, 20, 20, 20, 19, 20, 18, 20, 20	
	};
	cout << "Ding it right:\n";
	for (int i = 0; quizsores[i] == 20; i++) {
		cout << "quiz" << i << " is a 20\n";
	}

	cout << "Doing it dangerously wrong:\n";
	for (int i = 0; quizsores[i] = 20; i++) {
		cout << "quiz" << i << " is a 20\n";
	}

	return 0;
}
