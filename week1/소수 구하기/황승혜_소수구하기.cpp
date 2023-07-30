#include <iostream>
#include <math.h>

using namespace std;
bool isPrime(int n)
{
	if (n == 1) return false;
	else
	{
		for (int i = 2; i <= sqrt(n); i++)
		{
			if (n % i == 0) return false;
		}
	}
	return true;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int M, N;
	cin >> M >> N;
	for (int i = M; i <= N; i++)
	{
		if (isPrime(i)) cout << i << "\n";
	}
	return 0;
}