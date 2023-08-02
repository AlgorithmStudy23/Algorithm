import sys

input = sys.stdin.readline
n, m = map(int, input().split())
parent = [i for i in range(n)]


def find(a):
    if a == parent[a]:
        return a
    parent[a] = find(parent[a])
    return parent[a]

def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    if a > b:
        parent[a] = b
    else:
        parent[b] = a

for i in range(m):
    a, b = map(int, input().split())
    a = find(a)
    b = find(b)
    if a == b:
        print(i + 1)
        sys.exit()
    union(a, b)

print(0)
