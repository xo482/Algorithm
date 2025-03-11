def solution(s):
    s = s.lower()
    pc = 0
    yc = 0
    
    for c in s:
        if c == 'p' : pc += 1
        if c == 'y' : yc += 1
        
    return pc == yc