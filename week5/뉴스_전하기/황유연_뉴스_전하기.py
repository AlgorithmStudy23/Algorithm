def dfs(cur, graph):
    # print("cur,graph", cur, graph)
    child = graph[cur]
    if not child:
        return 1

    max_val = len(child)  # 최소 자식 갯수만큼 시간이 걸린다.
    arr = []  # 각 child의 최대값
    for node in child:
        arr.append(dfs(node, graph))
    arr.sort(reverse=True)
    time = 0
    for i in range(len(child)): # 시간이 더 오래 걸리는 자식부터 전화를 돌린다.
        max_val = max(max_val, time + arr[i])
        time += 1
    return max_val + 1


n = int(input())
graph = [[] for _ in range(n)]  # 트리 용도
li = list(map(int, input().split()))
for i in range(1, n):
    graph[li[i]].append(i)
result = dfs(0, graph) - 1
print(result)
