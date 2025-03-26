def solution(s):
    s = list(s)
    ans = []
    d = {}
    for idx in range(len(s)):
        key = s[idx]
        
        if key not in d: ans.append(-1)
        else: ans.append(idx-d[key])
        
        d[key] = idx
    
    return ans