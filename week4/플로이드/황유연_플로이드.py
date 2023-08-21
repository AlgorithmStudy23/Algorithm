from collections import defaultdict

n = int(input())
m = int(input())
MAX = float('inf')
cost = [[MAX] * (n + 1) for _ in range(n + 1)]
for i in range(n + 1):
    cost[i][i] = 0
for _ in range(m):
    a, b, c = map(int, input().split())
    cost[a][b] = min(c, cost[a][b])


# print(cost)


def floyd():
    global cost
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                # print(i,j,k)
                if cost[i][k] + cost[k][j] < cost[i][j]:
                    cost[i][j] = cost[i][k] + cost[k][j]


floyd()

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if cost[i][j] == MAX:
            print(0, end=' ')
            continue
        print(cost[i][j], end=' ')
    print()
