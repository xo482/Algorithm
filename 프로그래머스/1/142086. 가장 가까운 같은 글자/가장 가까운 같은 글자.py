def solution(s):
    s = list(s)
    ans = []
    d = {}
    for idx in range(len(s)):
        key = s[idx]
        if key not in d: s[idx] = -1
        else: s[idx] = idx-d[key]
        d[key] = idx
    
    return s