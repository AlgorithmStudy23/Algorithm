import sys

input = sys.stdin.readline
N, K = map(int, input().split())
arr = []
learned = ['a', 'n', 't', 'i', 'c']
not_learned = ['b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
               'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z']
for _ in range(N):
    word = input().strip()
    tmp = ''
    for x in word:
        if x not in learned:
            tmp += x
    arr.append(list(set(tmp)))
# print(arr)
ans = 0


def dfs(n, idx):
    if n == 0:
        get_count()
        return
    for i in range(idx, len(not_learned)):
        learned.append(not_learned[i])
        dfs(n - 1, i + 1)
        learned.pop()


def get_count():
    global ans
    result = 0
    for words in arr:
        flag = True
        for x in words:
            if x not in learned:
                flag = False
                break
        if flag:
            result += 1
    ans = max(ans, result)
    return


if K < 5:
    print(ans)
else:
    dfs(K - 5, 0)
    print(ans)
