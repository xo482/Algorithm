def solution(t, p):
    st = len(t)
    sp = len(p)
    
    pi = int(p)
    
    cnt=0
    for i in range(st-sp+1):
        ti = int(t[i:i+sp])
        if ti <= pi:
            cnt+=1
    return cnt
    
    
    
    
    return answer