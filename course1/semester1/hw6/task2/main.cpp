#include <iostream>
#include <string.h>

using namespace std;

int const byteSize = 8;

char *outByte(unsigned char ch)
{
	char *answer = new char[byteSize + 1];
	answer[0] = '\0';

	unsigned char mask = 0b10000000;
	for (int i = 0; i < 8; i++)
	{
		if (ch & mask)
			strcat(answer, "1");
		else
			strcat(answer, "0");
		mask = mask >> 1;
	}

	return answer;
}

char *output(int n)
{
	char *answer = new char[4 * byteSize + 1];
	answer[0] = '\0';

	unsigned char *x = reinterpret_cast<unsigned char*>(&n);

	for (int i = 3; i >= 0; i--)
	{
		char *temp = outByte(x[i]);
		strcat(answer, temp);
		delete[] temp;
	}

	return answer;
}

char *aPlusB(char *a, char *b)
{
	char *answer = new char[4 * byteSize + 1];
	answer[4 * byteSize] = '\0';

	bool nextBit = false;
	for (int i = 4 * byteSize - 1; i >= 0; i--)
	{
		if ((a[i] == '0') && (b[i] == '0'))
		{
			answer[i] = '0' + nextBit;
			nextBit = false;
			continue;
		}

		if ((a[i] == '0') && (b[i] == '1') || (a[i] == '1') && (b[i] == '0'))
		{
			if (nextBit)
			{
				answer[i] = '0';
				nextBit = true;
			}
			else
			{
				answer[i] = '1';
				nextBit = false;
			}
			continue;
		}

		if ((a[i] == '1') && (b[i] == '1'))
		{
			answer[i] = '0' + nextBit;
			nextBit = true;
			continue;
		}
	}

	return answer;
}

int transferToDecimal(char *binary)
{
	int answer = 0;
	int two = 1;

	char ch = '1';
	if (binary[0] == '1')
		ch = '0';

	for (int i = 4 * byteSize - 1; i >= 1; i--)
	{
		if (binary[i] == ch)
			answer += two;
		two *= 2;
	}

	if (binary[0] == '1')
		answer = (-1) * (answer + 1);

	return answer;
}

int main()
{
	int a = 0;
	int b = 0;

	cout << "Enter A & B: ";
	cin >> a >> b;

	cout << "A(2)  =  ";
	char *stringA = output(a);
	cout << stringA << endl;
	cout << "B(2)  =  ";
	char *stringB = output(b);
	cout << stringB << endl;

	cout << "Sum(2) = ";
	char *sum = aPlusB(stringA, stringB);
	cout << sum << endl;
	cout << "Sum(10) = " << transferToDecimal(sum) << endl;

	delete[] stringA;
	delete[] stringB;
	delete[] sum;
	return 0;
}