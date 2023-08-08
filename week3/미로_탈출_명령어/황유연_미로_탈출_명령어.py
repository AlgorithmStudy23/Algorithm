from heapq import heappush, heappop


def solution(n, m, x, y, r, c, k):
    def bfs(x, y, r, c, k):
        answer_list = []
        q = [['', k, [x, y]]]  # d
        dirs = [(1, 0, 'd'), (0, -1, 'l'), (0, 1, 'r'), (-1, 0, 'u')]
        while q:
            path, k, [x, y] = heappop(q)
            if k < 0:
                continue
            if x == r and y == c:
                if k == 0:
                    answer_list.append(path)
                    continue
                if k % 2 != 0:
                    continue
            for dx, dy, d in dirs:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    if nx == r and ny == c and k - 1 == 0:
                        answer_list.append(path + d)
                        continue
                    heappush(q, [path + d, k - 1, [nx, ny]])
        return answer_list

    answer_list = bfs(x - 1, y - 1, r - 1, c - 1, k)
    answer_list.sort()
    if answer_list:
        answer_list.sort()
        return answer_list[0]
    else:
        return "impossible"


# print(solution(3, 4, 2, 3, 3, 1, 5))  # dllrl
# print(solution(2, 2, 1, 1, 2, 2, 2))  # 'dr'
# print(solution(3, 3, 1, 2, 3, 3, 4))  # "impossible"
