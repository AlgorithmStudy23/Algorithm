def solution(stones, k):
    min_ = sum(stones[:k])
    min_window = [stones[:k]]
    window_sum = sum(stones[:k])
    for i in range(k, len(stones)):
        window_sum += stones[i]
        window_sum -= stones[i - k]
        if min_ > window_sum:
            min_ = window_sum
            min_window = stones[i - k + 1:i + 1]
            # print(min_window)

    return max(min_window)

