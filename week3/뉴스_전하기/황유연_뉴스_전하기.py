import sys
from collections import deque

N = int(input())
li = list(map(int, input().split()))
ans = 0
tree = {}
for i in range(N + 1):
    tree[i] = []

for i in range(1, N):
    p = li[i]
    tree[p].append(i)

if not tree[0]:
    print(0)
    sys.exit()


def bfs(x, level):
    q = deque()
    visited = [0 for _ in range(N)]
    q.append([x, level])
    visited[x] = 0
    while q:
        x, level = q.popleft()
        cnt = 1
        for i in tree[x]:
            if not visited[i]:
                visited[i] = level + cnt
                cnt += 1
                q.append([i, level + 1])
    # print(visited)
    return visited


# print(tree)

print(max(bfs(0, 0)))
