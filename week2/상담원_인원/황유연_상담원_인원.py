from heapq import heappush, heappop


def solution(k, n, reqs):  # 유형, 인원수, 요청
    answer = float('inf')
    memo = [[0] * 21 for _ in range(k + 1)]

    def calc_time(arr):  # memo에서 보고 시간 가져오기
        time = 0
        for i in range(k):  # 0, 1, 2 유형
            time += memo[i][arr[i] - 1]
        return time

    def dfs(total, div, path):  # 상담사 몇명 배치 하는지 조합
        nonlocal answer
        if div == 1:
            arr = path + [total]
            answer = min(answer, calc_time(arr.copy()))
            return
        for i in range(1, total - div + 2):
            dfs(total - i, div - 1, path + [i])

    def get_waiting_time(n, table):  # n명의 상담사, 시간표가 주어졌을 때 소요 시간
        q = [0 for _ in range(n)]
        waiting_time = 0
        for start, dur in table:
            available = heappop(q)
            if available <= start:
                heappush(q, start + dur)
            else:
                heappush(q, available + dur)
                waiting_time += available - start
        return waiting_time

    table = [[] for _ in range(k)]
    for a, b, c in reqs:
        table[c - 1].append([a, b])

    MAX = n - k + 1
    memo = [[0 for _ in range(MAX)] for _ in range(k)]  # 행: 상담 유형, 열: 상담사 최대 배정 수
    for i in range(k):
        for j in range(1, MAX + 1):
            memo[i][j - 1] = get_waiting_time(j, table[i])
    dfs(n, k, [])
    return answer

