#include <iostream>

using namespace std;

void exponentialForm(double n)
{
	unsigned char *bin = reinterpret_cast<unsigned char*>(&n);
	
	bool zero = true;
	for (int i = 0; i < 8; i++)
		if (bin[i] != 0)
			zero = false;

	if (zero == true)
	{
		cout << "0.0";
		return;
	}	

	unsigned char signMask = 0b10000000;
	unsigned char exponentMask = 0b01111111;
	unsigned char mantissaMask = 0b00001111;

	if (bin[7] & signMask)
		cout << "-";

	double temp = 1;
	temp += (double)(bin[6] & mantissaMask) / 16;
	long long divider = 16 * 256;
	for (int i = 5; i >= 0; i--)
	{
		temp += (double)bin[i] / divider;
		divider *= 256;
	}

	cout << temp << "*2^";

	int power = (bin[7] & exponentMask) * 16 + (bin[6] & ~mantissaMask) / 16 - 1023;
	
	if (power >= 0)
		cout << power << endl;
	else
		cout << "(" << power << ")" << endl;
}

int main()
{
	double n = 0;
	cout.precision(20);

	cout << "Enter a number: ";
	cin >> n;
	cout << "Result: ";
	exponentialForm(n);
	cout << endl;

	return 0;
}