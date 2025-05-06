def solution(num_list):
    m = 1
    p = 0
    
    for v in num_list:
        m *= v
        p += v
        
    return 1 if m < p*p else 0