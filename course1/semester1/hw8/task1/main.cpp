#include <iostream>

using namespace std;

int variant(int *students, int student, int originalStudent)
{
	if (student < 3)
		return student + 1;

	if (students[student] == originalStudent)
		return 0;
	else
		return variant(students, students[student], originalStudent);
}

void result(int *students, int size)
{
	for (int i = 0; i < size; i++)
	{
		int temp = variant(students, i, i);
		if (temp != 0)
			cout << "Student " << i + 1 << " complite " << temp << " variant" << endl;
		else
			cout << "Student " << i + 1 << " mast be expelled!" << endl;
	}

	cout << endl;
}

int *input(int &size)
{
	cout << "Enter number of students: ";
	cin >> size;

	cout << "Enter student in format (student  author of variant (if student didn't pass work, enter 0)): ";
	int *students = new int[size];
	for (int i = 0; i < size; i++)
	{
		int st = 0;
		cin >> st;
		cin >> students[st - 1];
		students[st - 1]--;
	}

	cout << endl;
	return students;
}

int main()
{
	int size = 0;
	int *students = input(size);
	
	result(students, size);
	
	delete[] students;
	return 0;
}