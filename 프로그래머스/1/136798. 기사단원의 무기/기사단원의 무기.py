def solution(number, limit, power):
    ans = 0
    for i in range(1, number+1):
    
        cnt = 0
        for j in range(1, int(i**(1/2)+1)):
            if i % j == 0: 
                cnt += 2
                if j*j == i:
                    cnt -= 1
        
        if cnt > limit: 
            cnt = power
        
        ans += cnt
    
    return ans  