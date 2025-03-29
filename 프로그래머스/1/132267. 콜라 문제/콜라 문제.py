def solution(a, b, n):
    ans = 0
    while n >= a:
        ans += n // a * b   
        n = n - n // a * a + n // a * b
        
    
    return ans