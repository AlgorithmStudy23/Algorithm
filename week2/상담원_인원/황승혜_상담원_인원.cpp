#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
#include <algorithm>

using namespace std;

bool comp(pair<int, int> a, pair<int, int>b)
{
	if (a.second == b.second)
		return a.first < b.first;
	return a.second > b.second;
}

int solution(int k, int n, vector<vector<int>> reqs) {
	int answer = 0;

	// 유형별로 멘토 최소 1명씩 배정
	vector<pair<int, int>> mento;
	for (int i = 0; i < k; i++)
	{
		mento.push_back({ 1,0 }); 
	}

	//멘토가 1명씩일때 대기시간 측정
	vector<pair<int,int>> wait(k);
	for (int i = 1; i <= k; i++)
	{
		wait.push_back({ i,0 });
	}
	for (int i = 0; i < reqs.size(); i++)
	{
		int type = reqs[i][2];
		if (mento[type - 1].second == 0)
		{
			mento[type - 1].second += (reqs[i][1] + reqs[i][0]);
		}
		else
		{
			wait[type - 1].second += (mento[type - 1].second - reqs[i][0]);
			mento[type - 1].second += reqs[i][1];
		}
	}
	sort(wait.begin(), wait.end(), comp);
	//대기시간이 가장 긴 유형에 멘토 추가
	for (int i = 0; i < k-2; i++)
	{
		
	}
	return answer;
}
