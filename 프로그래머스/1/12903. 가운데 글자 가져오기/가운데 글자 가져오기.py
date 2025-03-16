def solution(s):
    size = len(s)
    s = list(s)
    
    if size % 2 == 0: 
        return ''.join([s[size//2-1], s[size//2]])
    else:
        return s[size//2]