#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <tuple>
#include <cmath>

using namespace std;

int N, M;
int parent[1001];
vector<pair<int, int>> v;
vector<tuple<double, int, int>> vv; //w, x, y

double weight(int x1, int y1, int x2, int y2)
{
	double x_dist = pow(x1 - x2, 2);
	double y_dist = pow(y1 - y2, 2);
	return sqrt(x_dist + y_dist);
}

int find(int i)
{
	if (parent[i] == i) return i;
	else parent[i] = find(parent[i]);
}

bool union_node(int x, int y)
{
	x = find(x);
	y = find(y);
	if (x == y) return false; // 사이클
	else
	{
		parent[x] = y; // 부모노드로 지정
		return true;
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> N >> M;
	v.push_back({ 0,0 });
	for (int i = 1; i <= N; i++)
	{
		// 좌표
		parent[i] = i;
		int x, y;
		cin >> x >> y;
		v.push_back({ x, y });
	}
	for (int i = 0; i < M; i++)
	{
		// 이미 만들어진 그래프
		int n1, n2;
		cin >> n1 >> n2;
		union_node(n1, n2);
	}
	
	for (int i = 1; i <= N-1; i++)
	{
		for (int j = i + 1; j <= N; j++)
		{
			double w = weight(v[i].first, v[i].second, v[j].first, v[j].second);
			vv.push_back(make_tuple(w,i,j));// i번, j번, 가중치(거리) 
		}
	}
	double result = 0;
	sort(vv.begin(), vv.end());
	for (int i = 0; i < vv.size(); i++)
	{
		int xx = get<1>(vv[i]);
		int yy = get<2>(vv[i]);
		double ww = get<0>(vv[i]);
		if (union_node(xx, yy))
			result += ww;
	}
	cout << result << '\n';
	return 0;
}