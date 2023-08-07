def solution(k, n, reqs):  # 유형, 인원수, 요청
    answer = float('inf')
    arr = [1 for _ in range(k + 1)]
    arr[0] = 0

    def calc_time(arr):
        nonlocal answer
        finish_time = []
        latency = 0
        for x in arr:
            finish_time.append([0] * x)
        for a, b, c in reqs:
            if latency >= answer:
                return float('inf')
            ctime = finish_time[c]  # c 유형의 시작 가능한 상담원 시간
            ctime.sort()
            if ctime[0] <= a:
                ctime[0] = a + b  # 원하는 시간부터 시작해서 종료, 종료 시간 저장
            else:
                latency += (ctime[0] - a)
                ctime[0] = ctime[0] + b
        return latency

    def dfs(n, arr):
        nonlocal answer
        if sum(arr) == n:
            # print(arr)
            answer = min(answer, calc_time(arr.copy()))
            return
        for i in range(1, k + 1):
            arr[i] += 1
            dfs(n, arr)
            arr[i] -= 1

    dfs(n, arr)
    return answer
