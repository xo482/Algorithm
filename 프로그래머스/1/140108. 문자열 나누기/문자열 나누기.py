def solution(s):
    ans = 0
    
    first = None
    sc = 0
    dc = 0
    
    for v in s:
        if first is None: first = v
        if first == v: sc += 1
        if first != v: dc += 1
            
        if sc == dc:
            first = None
            sc = 0
            dc = 0
            ans += 1
    
    if sc != dc: ans += 1
    return ans