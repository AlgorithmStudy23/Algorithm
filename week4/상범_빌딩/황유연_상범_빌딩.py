import sys
from collections import deque

while True:
    L, R, C = map(int, sys.stdin.readline().split())
    if L == 0 and R == 0 and C == 0: # 종료 조건
        break
    building = []
    start = []
    end = []
    for i in range(L):
        li = []
        for j in range(R):
            tmp = list(sys.stdin.readline().strip())
            li.append(tmp)
            for k in range(len(tmp)):
                if tmp[k] == 'S':
                    start = [i, j, k]  # 높이, 행, 열
                if tmp[k] == 'E':
                    end = [i, j, k] 
        sys.stdin.readline().strip()
        building.append(li)


    def bfs(start):
        q = deque()
        q.append([start, 0])
        visited = [[[0 for _ in range(C)] for _ in range(R)] for _ in range(L)]
        visited[start[0]][start[1]][start[2]] = 1
        dirs = [(0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1), (1, 0, 0), (-1, 0, 0)] # 4방향 + 층 이동
        while q:
            [l, r, c], t = q.popleft()
            if [l, r, c] == end:
                return t
            for dz, dy, dx in dirs:
                nl, nr, nc = l + dz, r + dx, c + dy
                if 0 <= nl < L and 0 <= nr < R and 0 <= nc < C and not visited[nl][nr][nc] and building[nl][nr][nc] != '#':
                    visited[nl][nr][nc] = 1
                    q.append([[nl, nr, nc], t + 1])

        return -1


    res = bfs(start)
    if res == -1:
        print('Trapped!')
    else:
        print("Escaped in {0} minute(s).".format(res))
