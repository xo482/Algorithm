import math
def solution(n):
    n = math.sqrt(n)
    
    if n == n // 1:
        return pow(n+1,2)
    return -1