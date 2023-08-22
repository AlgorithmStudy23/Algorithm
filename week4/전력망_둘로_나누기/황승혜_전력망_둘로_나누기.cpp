#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> v;
int bfs(int n)
{
    vector<int> visit(v.size());
    queue<int> q;
    q.push(1);
    int cnt = 0;
    while (!q.empty())
    {
        int node = q.front();
        q.pop();
        if (visit[node] == 1) continue;
        visit[node] = true;
        cnt++;
        for (int i = 0; i < v[node].size(); i++)
            q.push(v[node][i]);
    }
    int cnt2 = n - cnt;
    return abs(cnt - cnt2);
}
int solution(int n, vector<vector<int>> wires) {
    int answer = 2000;
    for (int i = 0; i < n - 1; i++)
    {
        v = vector<vector<int>>(n + 1);
        for (int j = 0; j < n - 1; j++)
        {
            if (j == i) continue; // ²÷À» ¼±
            int x = wires[j][0];
            int y = wires[j][1];
            v[x].push_back(y);
            v[y].push_back(x);
        }
        answer = min(answer, bfs(n));
        v.clear();
    }
    return answer;
}