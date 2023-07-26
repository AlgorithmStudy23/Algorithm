#include <iostream>
#include <vector>
#include <string>
using namespace std;


// 길이  0  1  2  3  4  5
// 암호     2  5  1  1  4
// dp[i] 1  1  2  2  3  6

int dp[5001] = { 0, };

int dpcount(const string& code)
{
	int n = code.length();
	dp[0] =1;
	for (int i = 1; i <=n; ++i)
	{
		// 한자릿수로 해석할 때,
		if (code[i - 1] >= '1' && code[i - 1] <= '9')
		{
			dp[i] += dp[i - 1];
		}

		// 두자릿수로 해석할 때,
		if (i >= 2)
		{
			// 숫자계산
			int num = (code[i - 2] - '0') * 10 + (code[i - 1] - '0');
			if (num >= 10 && num <= 26)
			{
				dp[i] += dp[i - 2];
			}
		}
	}
	return dp[n];
}
int main()
{
	string s;
	cin >> s; 

	// 반례
	// 1. 쓰레기값이 들어오는경우
	// 2. '0' 처리

	int answer = dpcount(s) % 1000000;
	cout << answer << endl;
	return 0;
}
