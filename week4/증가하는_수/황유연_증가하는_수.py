dp = [-1 for _ in range(10000)]
for i in range(10):
    dp[i]=i
n = int(input())
li = []

for _ in range(n):
    li.append(int(input()))

def is_increase_num(st):
    st = str(st)
    prv = '0'
    is_increase = True
    for x in st:
        if prv > x:
            is_increase = False
            break
        prv = x
    return is_increase


def get_count(x):
    if dp[x] > 0:
        return dp[x]

    for i in range(x+1):
        if dp[i] < 0:
            if is_increase_num(i):
                dp[i] = dp[i - 1] + 1
            else:
                dp[i] = dp[i - 1]
    return dp[x]

for x in li:
    if not is_increase_num(x):
        print(-1)
        continue
    increase = get_count(x)
    if increase == -1:
        print(-1)
    else:
        print(increase)
