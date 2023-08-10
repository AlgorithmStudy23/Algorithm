import sys
input= sys.stdin.readline
from queue import PriorityQueue

v,e = map(int, input().split())
k = int(input())

distance = [sys.maxsize] * (v + 1) #무한대값으로 초기화
visited = [False] * (v + 1)
myList = [[] for _ in range(v + 1)]
q = PriorityQueue()

for _ in range(e):
    u, v, w = map(int, input().split())
    myList[u].append((v, w))

#다익스트라
q.put((0, k))
distance[k] = 0

while q.qsize() > 0:
    current = q.get()
    c_v = current[1]

    if visited[c_v]:
        continue
    
    visited[c_v] = True
    for temp in myList[c_v]:
        next = temp[0]
        value = temp[1]

        if distance[next] > distance[c_v] + value: #최소거리로 업데이트함
            distance[next] = distance[c_v] + value
            q.put((distance[next], next)) #가중치가 정렬 기준이므로 순서를 가중치,, 목표노드순으로 우선순위 큐

for i in range(1, v + 1):
    if visited[i]:
        print(distance[i])
    else:
        print("INF")

