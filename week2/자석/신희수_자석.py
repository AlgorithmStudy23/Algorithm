n, k = map(int, input().split())
num1 = list(map(int, input().split()))

num2 = sorted(num1)
max_value = num2[-1]
max_value_index = num1.index(max_value)
min_value = num2[0]
min_value_index = num1.index(min_value)

result = max_value - min_value - (k * abs(max_value_index - min_value_index))
print(result)

# result 값들을 저장하는 리스트
results = []

# 나머지 값들과 비교하여 최댓값 찾기
for i in range(1, n+1):
    value = num2[i] - min_value - (k * abs(i - min_value_index))
    results.append(value)

for i in range(0, n):
    value = max_value - num2[i] - (k * abs(i - min_value_index))
    results.append(value)

# 결과 리스트에서 최댓값 찾기
max_result = max(results)
print(max_result)


