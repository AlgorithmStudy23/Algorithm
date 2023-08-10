from collections import deque

#상하좌우
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(board, dir):
    n = len(board)
    price = [[int(1e9)] * n for _ in range(n)]
    price[0][0] = [0]

    queue = deque()
    queue.append((0, 0, 0, dir))

    while queue:
        x, y, c, d = queue.popleft()

        if x == n-1 and y == n-1:
            continue

        for i in range(4): #상하좌우 반복
            nx = x + dx[i]
            ny = y + dy[i]
            nd = i




def solution(board):
    answer = min(bfs(board, 0), bfs(board, 2))
    return answer