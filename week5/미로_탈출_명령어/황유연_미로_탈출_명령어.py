import sys
input = sys.stdin.readline

sys.setrecursionlimit(100000)


def solution(n, m, x, y, r, c, k):
    dirs = [('d', 1, 0), ('l', 0, -1), ('r', 0, 1), ('u', -1, 0)]
    answer = 'z'

    dist = abs(x - r) + abs(y - c)
    if dist > k or (k - dist) % 2 == 1:
        return "impossible"
    r -= 1
    c -= 1
    def dfs(x, y, path, k):
        nonlocal answer
        # print(x, y, path)
        if k - (abs(r - x) + abs(c - y)) % 2 == 1:
            return

        if x == r and y == c:
            if k == 0:
                answer = path
                return
            if k % 2 == 1:
                return
        for dir, dx, dy in dirs:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and path + dir < answer:
                if abs(r - nx) + abs(c - ny) > k:
                    continue
                dfs(nx, ny, path + dir, k - 1)

    dfs(x - 1, y - 1, '', k)
    if answer == 'z':
        return "impossible"
    return answer

