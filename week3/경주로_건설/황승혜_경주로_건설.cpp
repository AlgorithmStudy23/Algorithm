#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { 1,0,-1,0 };
// down, right, up, left

int solution(vector<vector<int>> board) {
    int answer = 9999999;
    int width = board[0].size();
    int height = board.size();
    vector<vector<vector<int>>> dp(width, vector<vector<int>>(height, vector<int>(4, 0)));
    queue<pair<pair<int, int>, int>> q;
    q.push({ { 0, 0 }, 0 }); // x, y, direction
    while (!q.empty())
    {
        int x = q.front().first.first;
        int y = q.front().first.second;
        int dir = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 수정
            int new_dir = i;
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
            if (board[nx][ny] == 1) continue;
            
            // 수정
            if (new_dir == dir)
            {
                dp[nx][ny][new_dir] = min(dp[x][y][dir] + 100, dp[nx][ny][new_dir]);
            }
            else
            {
                dp[nx][ny][new_dir] = min(dp[x][y][dir] + 600, dp[nx][ny][new_dir]);
            }
            // 수정
            q.push({ { nx, ny }, new_dir });
        }
    }
    for (int i = 0; i < 4; i++)
    {
        answer = min(dp[width - 1][height - 1][i], answer);
    }
    return answer;
}