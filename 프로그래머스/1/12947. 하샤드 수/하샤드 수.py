def solution(x):
    
    sum = 0
    ls = list(str(x))
    for i in ls:
        sum += int(i)
        
    return x%sum==0