import heapq
import sys

N, M = map(int, input().split())
adj = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B, C = map(int, input().split())
    adj[A].append([C, B])  # 비용, 노드


def dijk():
    q = [[0, 1]]  # 시작 1, 비용 0
    costs = [float('inf') for _ in range(N + 1)]
    costs[1] = 0
    while q:
        cost, node = heapq.heappop(q)
        for next_cost, next_node in adj[node]:
            next_cost += cost
            if next_cost < costs[next_node]:
                if next_cost <= 0 :
                    print(-1)
                    sys.exit()
                costs[next_node] = next_cost
                heapq.heappush(q, [next_cost, next_node])

    return costs


costs = dijk()
for i in range(2, N + 1):
    if costs[i] == float('inf'):
        print(-1)
        continue
    print(costs[i])
