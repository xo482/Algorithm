def solution(d, budget):
    
    if len(d)==0: return 0
    
    d.sort()
    ans = 0
    while budget > 0:
        budget -= d[ans]
        if budget < 0: break
        ans += 1
        
        if len(d) == ans: break
        
    return ans