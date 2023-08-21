N, K = map(int, input().split())

tables = [int(x) for x in input().split()]
# 차이값 계산 용도
left_right = []
right_left = []

for i in range(1, N):  # 왼쪽->오른쪽
    left_right.append(tables[i - 1] - tables[i] - K)

for i in range(1, N):  # 오른쪽->왼쪽
    right_left.append(tables[i] - tables[i - 1] - K)
  
tmp1 = [0] * (N - 1)
tmp1[0] = left_right[0]
for i in range(1, N - 1): # 음수발생시 상쇄
    tmp1[i] = max(0, tmp1[i - 1]) + left_right[i]
tmp2 = [0] * (N - 1)
tmp2[0] = right_left[0]
for i in range(1, N - 1):
    tmp2[i] = max(0, tmp2[i - 1]) + right_left[i]
print(max((max(tmp1), max(tmp2))))
