#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

int l, r, c, cnt;
bool flag;
char field[31][31][31];
int fieldcount[31][31][31];
int visit[31][31][31];
int dx[6] = { 1,-1,0,0,0,0 };
int dy[6] = { 0,0,1,-1,0,0 };
int dz[6] = { 0,0,0,0,1,-1 };

void bfs(int x, int y, int z) {
	queue<pair<pair<int, int>, int>>q;
	q.push({ {x,y},z });
	visit[x][y][z] = 1;
	while (!q.empty()) {
		int nx = q.front().first.first;
		int ny = q.front().first.second;
		int nz = q.front().second;
		q.pop();
		for (int i = 0; i < 6; i++) {
			int newx = nx + dx[i];
			int newy = ny + dy[i];
			int newz = nz + dz[i];
			if (newx < 0 || newy < 0 || newz < 0 || newx >= l || newy >= r || newz >= c) continue;
			if (field[newx][newy][newz] == '#' || visit[newx][newy][newz] == 1) continue;
			if (field[newx][newy][newz] == '.') {
				cnt++;
				q.push({ {newx,newy},newz });
				visit[newx][newy][newz] = 1;
				fieldcount[newx][newy][newz] = fieldcount[nx][ny][nz] + 1;
			}
			if (field[newx][newy][newz] == 'E') {
				cnt++;
				flag = true;
				q.push({ {newx,newy},newz });
				visit[newx][newy][newz] = 1;
				fieldcount[newx][newy][newz] = fieldcount[nx][ny][nz] + 1;
			}
		}
	}
}

int main() {
	while (1) {
		cin >> l >> r >> c;
		if (l == 0 && r == 0 && c == 0) break;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					cin >> field[i][j][k];
				}
			}
		}
		cnt = 0;
		flag = false;
		memset(visit, 0, sizeof(visit));
		memset(fieldcount, 0, sizeof(fieldcount));
		int tx, ty, tz;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (field[i][j][k] == 'S') bfs(i, j, k);
					if (field[i][j][k] == 'E') {
						tx = i; ty = j; tz = k;
					}
				}
			}
		}
		if (flag) cout << "Escaped in " << fieldcount[tx][ty][tz] << " minute(s).\n";
		else cout << "Trapped!\n";
	}
}