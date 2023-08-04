def solution(numbers):
    answer_list = []
    visited = [0 for _ in range(len(numbers))]

    def is_prime(num):
        if num < 2:
            return False
        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                return False
        return True

    def dfs(res):
        nonlocal answer_list
        if len(res) != 0:
            num = int("".join(res))
            if is_prime(num):
                answer_list.append(num)
        for i in range(len(numbers)):
            if not visited[i]:
                visited[i] = 1
                res.append(numbers[i])
                dfs(res)
                res.pop()
                visited[i] = 0

    dfs([])
    return len(set(answer_list))

