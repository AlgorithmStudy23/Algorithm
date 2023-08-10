from heapq import heappop, heappush


def solution(board):
    answer = 0
    N = len(board)
    M = len(board[0])

    def bfs(x, y):
        q = [[0, -1, [x, y]]]  # 비용, 방향, x, y
        dirs = [(1, 0), (0, -1), (0, 1), (-1, 0)]
        costs = [[0] * M for _ in range(N)]
        # visited[0][0] = 1
        while q:
            c, d, [x, y] = heappop(q)
            if x == N - 1 and y == M - 1:
                return c
            for i in range(len(dirs)):
                dx, dy = dirs[i]
                nx, ny = x + dx, y + dy
                if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0:
                    if d == -1:
                        q.append([c + 100, i, [nx, ny]])
                    elif d != i:
                        q.append([c + 600, i, [nx, ny]])

    return bfs(0, 0)
