#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int dx[4] = { 0, -1, 1, 0 };
int dy[4] = { 1, 0, 0, -1 }; // d l r u
char ss[4] = { 'd', 'l', 'r', 'u' };
string solution(int n, int m, int x, int y, int r, int c, int k) {
    string answer = "";
    int startx = n;
    int starty = m;
    int endx = r;
    int endy = c;
    int dist = abs(n - r) + abs(m - c);
    if (dist > k) return "impossible";
    if ((k - dist) % 2 != 0) return "impossible";
    vector<string> v;
    queue<pair<int, int>> q;
    q.push({ startx, starty });
    int cnt = 0;
    string temp;
    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            temp += ss[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (nx == r && ny == c && cnt == k)
            {
                v.push_back(temp);
                temp = "";
            }
            cnt++;
            q.push({ nx, ny });
        }
    }
    sort(v.begin(), v.end());
    answer = v[0];
    return answer;
}

int main()
{
    cout << solution(2, 4, 2, 3, 3, 1, 5);
    return 0;
}