from collections import deque

N, M = map(int, input().split())
li = []
pipe = []
x_max = 0
y_max = 0
for _ in range(N):
    a, b = map(int, input().split())
    x_max = max(a, x_max)
    y_max = max(b, y_max)
    li.append([a, b])
visited = [[0 for _ in range(y_max + 1)] for _ in range(x_max + 1)]
for _ in range(M):
    x, y = map(int, input().split())
    # pipe.append([li[x - 1], li[y - 1]])
    # print(li[x - 1])
    pipe.append(li[x - 1])
    pipe.append(li[y - 1])
    tmpx = li[x - 1]
    tmpy = li[y - 1]
    li.remove(tmpx)
    li.remove(tmpy)

for x, y in pipe:
    visited[x][y] = 1


def bfs(pipe):
    global visited
    dirs = [(0, 1), (1, 0), (-1, 0), (0, -1)]
    q = deque(pipe)
    while q:
        x, y = q.popleft()
        for dx, dy in dirs:
            nx, ny = x + dx, y + dy
            if 0 < nx <= x_max and 0 < ny <= y_max and not visited[nx][ny]:
                visited[nx][ny] = visited[x][y] + 1
                q.append([nx, ny])


bfs(pipe)

ans = 0
for x, y in li:
    ans += visited[x][y] - 1
print("{:.2f}".format(ans))
