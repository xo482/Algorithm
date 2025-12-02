import sys
input = sys.stdin.readline

n, p = map(int, input().split())
arr = sorted([list(map(int, input().split())) for _ in range(p)], key=lambda x: -x[1])

dp = [0 for _ in range(n+1)]
dp[0] = 1 << 23

for l, c in arr:
    for i in range(n, l - 1, -1):
        if dp[i - l]:
            dp[i] = max(dp[i], min(dp[i - l], c))
        if dp[n]: break
    if dp[n]: break

print(dp[n])