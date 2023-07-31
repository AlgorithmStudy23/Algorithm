def solution(stones, k):
    left = 1 
    right = 200000000 

    # 이분 탐색
    while left <= right:
        mid = (left + right) // 2 
        cnt = 0
        for x in stones:
            if x - mid <= 0:
                cnt += 1
            else:
                cnt = 0
            if cnt >= k: # 연속으로 k개 이상을 못 건넌다면
                break
        
        if cnt >= k: # 건너는 친구 수 줄이기
            right = mid - 1
        else: # 늘리기
            left = mid + 1

    return left
