import sys
input = sys.stdin.readline

n,m = map(int, input().split())
info = list(map(int, input().split()))

con = [[] for _ in range(n+1)]
for _ in range(m):
    n1, n2 = map(int, input().split())
    if info[n1-1] < info[n2-1]:
        con[n1].append(n2)
    if info[n2-1] < info[n1-1]:
        con[n2].append(n1)

ls = []
for i in range(n):
    ls.append((-info[i], i+1))
ls.sort()

dp = [1 for _ in range(n+1)]
while ls:
    _, now = ls.pop(0)

    for nxt in con[now]:
        if dp[now] < dp[nxt] + 1:
            dp[now] = dp[nxt] + 1

for i in range(1, n+1):
    print(dp[i])