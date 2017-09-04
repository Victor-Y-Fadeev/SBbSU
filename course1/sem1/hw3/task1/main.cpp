#include <iostream>

using namespace std;

int main()
{
	int a = 0;
	int n = 0;

	cout << "Enter A^n: ";
	cin >> a >> n;

	int answer = 1;
	while (n > 0)
	{
		if (n % 2 == 0)
		{
			a *= a;
			n /= 2;
		}
		else
		{
			answer *= a;
			n--;
		}
	}

	cout << "Power = " << answer << endl;
	
	return 0;
}