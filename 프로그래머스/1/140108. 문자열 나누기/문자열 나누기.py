def solution(s):
    ls = list(s)
    ans = 0
    
    first = "0"
    sc = 0
    dc = 0
    
    for v in ls:
        if first == "0":
            first = v
        
            
        if first == v:
            sc += 1
        if first != v:
            dc += 1
            
        if sc == dc:
            first = "0"
            sc = 0
            dc = 0
            ans += 1
    
    if sc != dc: ans += 1
    return ans