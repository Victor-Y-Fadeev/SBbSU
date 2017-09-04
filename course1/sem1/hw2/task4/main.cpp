#include <iostream>

using namespace std;

void fraction(int denominator)
{
	float previous = 0;
	int minNumerator = denominator - 1;
	int minDenominator = denominator;
	float min = (float)(denominator - 1) / denominator;

	while (previous < min)
	{
		for (int i = 1; i < denominator; i++)
			for (int j = denominator; j > i; j--)
				if (((previous < (float)i / j) && ((float)i / j < min)) || ((i < minNumerator) && ((float)i / j == min)))
				{
					min = (float)i / j;
					minNumerator = i;
					minDenominator = j;
				}

		cout << minNumerator << " / " << minDenominator << endl;
		previous = min;
		min = (float)(denominator - 1) / denominator;
		minNumerator = denominator - 1;
		minDenominator = denominator;
	}
}


int main() {

	int denominator;
	cout << "Enter denominator = ";
	cin >> denominator;
	fraction(denominator);

	return 0;
}