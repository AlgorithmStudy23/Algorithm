N = int(input())
MAX = N * 100000
time = [0]
orders = [[] for _ in range(N + 1)]
for i in range(1, N + 1):
    li = list(map(int, input().split()))
    time.append(li[0])
    orders[i] = li[1:-1]
comp = [MAX for _ in range(N + 1)]


def get_time(x):
    if comp[x] != MAX:
        return
    if not orders[x]:
        comp[x] = time[x]
    tmp = time[x]
    for child in orders[x]:
        if comp[child] != MAX:
            tmp += comp[child]
        else:
            get_time(child)
            tmp += comp[child]


for i in range(len(orders)):
    order = orders[i]
    comp[i] = time[i]
    if not order:
        continue
    for child in order:
        if comp[child] == MAX:
            get_time(child)
        comp[i] += comp[child]

for i in range(1, N + 1):
    print(comp[i])
