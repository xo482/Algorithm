def solution(n):
    ls = []
    for i in range(0, n): 
        if i % 2 == 0: ls.append("수")
        else: ls.append("박")
    
    return ''.join(ls)