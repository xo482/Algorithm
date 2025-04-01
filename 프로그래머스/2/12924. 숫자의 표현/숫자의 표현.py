def solution(n):
    ans = 0
    dp = []
    dp.append(0)
    dp.append(1)
    for i in range(2, n+1):
        dp.append(dp[-1]+i)
        
    p1 = 1
    p2 = 1
    while p1 <= p2 and p2 <= n+1:
        now = dp[p2] - dp[p1-1]
        if now < n: p2 += 1
        if now >= n: 
            if now == n:
                ans += 1
            p1 += 1
        
        
    return ans