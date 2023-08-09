import sys

input = sys.stdin.readline
printf = sys.stdout.write
from heapq import heappush, heappop

V, E = map(int, input().split())
S = int(input())
adj = [[] for _ in range(V)]
for _ in range(E):
    u, v, w = map(int, input().split())
    adj[u - 1].append([v - 1, w])  # 다음노드, 가중치
costs = [float('inf') for _ in range(V)]
costs[S - 1] = 0  # 자기 자신 비용 0


def dijkstra(start):
    q = []
    q.append([0, start])
    while q:
        cost, node = heappop(q)
        if costs[node] < cost:
            continue
        for next_node, next_cost in adj[node]:
            if costs[next_node] > cost + next_cost:
                costs[next_node] = cost + next_cost
                heappush(q, [cost + next_cost, next_node])


dijkstra(S - 1)
for x in costs:
    if x == float('inf'):
        print("INF")
    else:
        print(x)
