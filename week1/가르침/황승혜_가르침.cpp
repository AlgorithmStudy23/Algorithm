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
		if ((mask & (1 << i)) == 0)   // mask�� i��° ���� �߰�
			result = max(result, dfs(i + 1, count + 1, mask | (1 << i)));

		// start : ���ĺ� �ε���
		// count : ���� ������ ���ĺ� ����
		// mask | (1 << i) : mask�� i��° ��Ʈ�� 1�� ������
		// result : ������� ���� ����� ���ο� dfs ��� �� �� ū���� ����(�ִ� �ܾ���� ���ϴ� ���̹Ƿ�)
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
			s[j] |= (1 << (s[j] - 'a'));// s[j] char�� bit�� ��ȯ
		}
	}

	// K�� 5���� ������ ���ڿ� ���� �� ����
	if (K < 5) cout << 0 << endl;
	else
	{
		K -= 5;

		// mask�� a n t i c �߰��Ͽ� dfs
		cout << dfs(0, 0, (1 << ('a' - 'a')) | (1 << ('c' - 'a')) | (1 << ('t' - 'a')) | (1 << ('i' - 'a')) | (1 << ('n' - 'a'))) << endl;
	}

	return 0;
}