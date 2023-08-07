from collections import deque
import sys
input = sys.stdin.readline
M, N = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(list(input()))


def bfs(x, y):
    q = deque([[0, x, y]])
    ans = N * M + 1
    dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    visited = [[0] * M for _ in range(N)]
    visited[0][0] = 1

    while q:
        z, x, y = q.popleft()
        visited[x][y] = 1

        if x == N - 1 and y == M - 1:
            ans = min(ans, z)
            continue

        for dx, dy in dirs:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and z < ans:
                if arr[nx][ny] == '0':
                    q.appendleft([z, nx, ny])
                else:
                    q.append([z + 1, nx, ny])

    return ans


print(bfs(0, 0))
