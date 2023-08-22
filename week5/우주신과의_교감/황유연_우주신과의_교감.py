N, M = map(int, input().split())
li = []
graph = []
parent = [i for i in range(N + 1)]


def union(a, b):
    global parent
    x = find(a)
    y = find(b)
    if x == y:
        return False
    if x > y:
        parent[x] = y
    else:
        parent[y] = x
    return True


def find(a):
    global parent

    if a == parent[a]:
        return a

    parent[a] = find(parent[a])
    return parent[a]


for i in range(N):
    a, b = map(int, input().split())
    for j in range(len(li)):
        x, y = li[j]
        dist = ((a - x) ** 2 + (b - y) ** 2) ** 0.5
        graph.append([dist, i + 1, j + 1]) # 거리, 노드 번호 저장
    li.append([a, b])
    
graph.sort() # 거리순 소팅

for i in range(M):
    a, b = map(int, input().split())
    union(a, b)

ans = 0

for cost, i, j in graph:
    if union(i, j): # 통신되는 우주신과 유니온 돼야하면 거리만큼 비용 더하기
        ans += cost

print("{:.2f}".format(ans))
