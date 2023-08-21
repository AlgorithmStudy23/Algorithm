import sys
input = sys.stdin.readline
n, m = map(int, input().split())
edges = []
distance = [sys.maxsize]*(n + 1)

for i in range(m):
    start, end, time = map(int, input().split())
    edges.append((start, end, time))

distance[1] = 0