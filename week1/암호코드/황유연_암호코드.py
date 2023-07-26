import sys

def dfs(idx, len_, li):
    global ans, n
    if idx == len_:
        tmp = ''
        for al in li:
            tmp += chr(int(al) + 96)
        ans.add(tmp)
        return
    if idx > len_:
        return
    li.append(n[idx])
    dfs(idx + 1, len_, li)
    li.pop()
    if idx + 2 <= len_ and 1 <= int(n[idx:idx + 2]) <= 26:
        li.append(n[idx:idx + 2])
        dfs(idx + 2, len_, li)


ans = set()
n = input()
for x in n:
    x = int(x)
    if x < 1 or x > 26:
        print(0)
        sys.exit()
len_ = len(n)
dfs(0, len_, [])
print(len(ans) % 1000000)
