import sys
input = sys.stdin.readline

n, p = map(int, input().split())
dp = [0 for _ in range(n+1)]
dp[0] = 1 << 23

for _ in range(p):
    l, c = map(int, input().split())

    for i in range(n, l - 1, -1):
        if dp[i - l]:
            dp[i] = max(dp[i], min(dp[i - l], c))

print(dp[n])