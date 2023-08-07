N = int(input())
cnt = 1
i = 1
N -= 1
while cnt <= N:
    cnt += 6 * i
    i += 1
print(i)
