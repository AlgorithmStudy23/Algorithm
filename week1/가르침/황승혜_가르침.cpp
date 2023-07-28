#include <iostream>
#include <string>
#include <vector>

using namespace std;

int N, K;
vector<int> str;

int bitmasking(int mask)
{
	int result = 0;
	for (int i = 0; i < str.size(); i++)
	{
		if ((str[i] & ((1 << 26) - 1 - mask)) == 0)
			result++;
	}
	return result;
}

int dfs(int start, int count, int mask)
{
	if (count == K)
		return bitmasking(mask);

	int result = 0;
	for (int i = start; i < 26; i++)
	{
		if ((mask & (1 << i)) == 0)   // mask에 i번째 글자 추가
			result = max(result, dfs(i + 1, count + 1, mask | (1 << i)));

		// start : 알파벳 인덱스
		// count : 현재 선택한 알파벳 개수
		// mask | (1 << i) : mask에 i번째 비트를 1로 설정함
		// result : 현재까지 구한 결과와 새로운 dfs 결과 값 중 큰값을 저장(최대 단어수를 구하는 것이므로)
	}

	return result;
}
int main()
{
	cin >> N >> K;
	for (int i = 0; i < N; i++)
	{
		string s;
		cin >> s;
		for (int j = 0; j < s.length(); j++)
		{
			s[j] |= (1 << (s[j] - 'a'));// s[j] char를 bit로 변환
		}
	}

	// K가 5보다 작으면 문자열 읽을 수 없음
	if (K < 5) cout << 0 << endl;
	else
	{
		K -= 5;

		// mask에 a n t i c 추가하여 dfs
		cout << dfs(0, 0, (1 << ('a' - 'a')) | (1 << ('c' - 'a')) | (1 << ('t' - 'a')) | (1 << ('i' - 'a')) | (1 << ('n' - 'a'))) << endl;
	}

	return 0;
}