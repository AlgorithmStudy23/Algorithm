import sys

MOD = 1000000
st = input()
if st[0] == '0':
    print(0)
    sys.exit()
dp = [0 for _ in range(len(st) + 1)]
dp[0] = dp[1] = 1
for i in range(1, len(st)):
    k = i + 1
    x = st[i]
    if '10' <= st[i - 1] + x <= '26':
        dp[k] += dp[k - 2]
    if '1' <= x <= '9':
        dp[k] += dp[k - 1]
    dp[k] = dp[k] % MOD
print(dp[-1] % MOD)
