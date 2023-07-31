
def solution(stones, k):
    left = 1 
    right = 200000000
    while left <= right:
        mid = (left + right) // 2 # 건넌 친구의 수 
        cnt = 0
        for x in stones:
            if x - mid <= 0:
                cnt += 1
            else:
                cnt = 0
            if cnt >= k:
                break
        if cnt >= k: # k 이상 건너 뛰어야 하면 정답 줄이기
            right = mid - 1
        else:
            left = mid + 1

    return left

