#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
#include <algorithm>

using namespace std;
int ans = 0;
vector<int> v;
void Combination(int start, int n, int r, vector<vector<string>> s)
{
	if (v.size() == r) {
		vector<vector<string>> temp(r);
		for (int i = 0; i < s.size(); i++) // 모든 튜플
		{
			vector<string> a;
			for (int j = 0; j < r; j++)
			{
				a.push_back(s[i][v[j]]); // i번째 튜플의 v[j]번째 속성
			}
			temp[i] = a;
		}
		// 후보키 체크
		if (is_permutation(temp.begin(), temp.end(), temp.begin()))
		{
			v.clear();
			return;
		}
		else
		{
			v.clear();
			ans++;
			return;
		}
	}
	for (int i = start; i < n; i++)
	{
		v.push_back(i);
		Combination(i, n, r, s);
		v.pop_back();
	}
	return;
}


int solution(vector<vector<string>> relation) {
	int n = relation[0].size(); // 4 (속성수)
	for (int i = 1; i <= relation.size(); i++)
	{
		Combination(0, n, i, relation);//  속성 n개중 i개 조합
	}
	int answer = ans;
	return answer;
}