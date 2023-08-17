import sys

def Cal_distance(p1, p2):
    return ((p1[0] - p2[0])**2 + (p1[1] - p2[1])**2) ** 0.5

n, m = map(int, input().split())
points = []

for _ in range(n):
    x, y = map(int, input().split())
    points.append((x, y))

min_total_distance = sys.maxsize

for i in range(n):
    total_distance = 0
    for j in range(n):
        if i != j:
            total_distance += Cal_distance(points[i], points[j])
    min_total_distance = min(min_total_distance, total_distance)

print("{:.2f}".format(min_total_distance))


