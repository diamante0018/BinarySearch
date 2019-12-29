#include <iostream>

bool binarySearch(int a[], int s,int n, int x) {
	bool found = false;
	int m;

	if (s <= n) {
		m = (s + n) / 2;

		if (a[m] == x) {
			found = true;
		}

		else {
			if (x < a[m])
				found = binarySearch(a, s, n - 1, x);

			else
				found = binarySearch(a, s + 1, n, x);
		}
	}

	return found;
}

int main(int argc, char *argv[]) {

	int a[13] = { 0,1,2,3,4,5,6,7,8,9,10,11,12 };
	int x;
	int n = sizeof(a) / sizeof(a[0]);

	printf("Enter the number you want to search in the Array A: ");
	scanf_s("%d", &x);

	bool b = binarySearch(a,0,n-1,x);

	if (b)
		printf("The number %d was found\n", x);

	else
		printf("The item %d was not found\n", x);

}


