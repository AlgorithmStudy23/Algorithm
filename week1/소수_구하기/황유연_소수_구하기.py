M, N = map(int, input().split())


def is_prime(M, N):
    N = N + 1
    prime = [True for _ in range(N)] 

    for i in range(2, int(N ** 0.5) + 1): # 2 ~ 5
        if prime[i]:
            for j in range(2 * i, N, i): # 4 ~ 25, 2
                prime[j] = False
    return prime


prime = is_prime(M, N)

for i in range(M, len(prime)):
    if prime[i] and i > 1:
        print(i)
