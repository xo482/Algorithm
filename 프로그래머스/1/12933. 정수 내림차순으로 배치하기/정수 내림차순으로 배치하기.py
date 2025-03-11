def solution(n):
    list = []
    while n > 0:
        list.append(n%10)
        n //= 10
        
    list.sort()
    list.reverse()
    
    s = ""
    for x in list:
        s += str(x)
        
    return int(s)