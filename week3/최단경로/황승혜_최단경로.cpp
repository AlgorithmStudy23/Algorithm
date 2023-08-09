#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
#define INF 987654321

vector<pair<int, int>> node[20005];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
int value[20005];

int main() {
	int vn, en;
	int start;
	int u, v, w;
	cin >> vn >> en; // 정점, 간선
	cin >> start; // 시작
	for (int i = 0; i < en; i++) {
		cin >> u >> v >> w; // 정점 정점 가중치
		node[u].push_back(make_pair(v, w));
	}
	for (int i = 1; i <= vn; i++) {
		value[i] = INF;
	}
	value[start] = 0;
	pq.push(make_pair(0, start)); // 가중치, 정점

	while (!pq.empty()) {
		int x = pq.top().first; // 가중치
		int y = pq.top().second; // 가리키는 정점
		pq.pop();
		for (int i = 0; i < node[y].size(); i++) {
			int a = node[y][i].first; // 정점 y에 연결된 정점
			int b = node[y][i].second; // 정점 y에 연결된 정점의 가중치
			if (x + b < value[a]) {
				value[a] = x + b;
				pq.push(make_pair(x + b, a));
			}
		}
	}
	for (int i = 1; i <= vn; i++) {
		if (value[i] == INF) cout << "INF" << "\n";
		else cout << value[i] << "\n";
	}
	return 0;
}
