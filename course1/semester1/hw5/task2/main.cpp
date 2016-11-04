#include <iostream>
#include "circularList.h"

using namespace std;

int killM(int n, int m)
{
	CircularList *list = createCricularList();
	for (int i = 1; i <= n; i++)
		add(list, i);

	for (int i = 0; i < n - 1; i++)
	{
		moveIterator(list, m - 1);
		removeIteratorElement(list);
	}

	int answer = getValue(list, 0);
	deleteCircularList(list);
	return answer;
}

int main()
{
	cout << "Enter n & m: ";
	
	int n = 0;
	int m = 0;
	cin >> n;
	cin >> m;
	
	cout << "K = " << killM(n, m) << endl;
	return 0;
}