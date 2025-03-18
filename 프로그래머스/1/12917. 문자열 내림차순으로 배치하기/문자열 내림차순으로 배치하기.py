def solution(s):
    ls = list(s)
    ls.sort()
    ls.reverse()
    
    return ''.join(ls)