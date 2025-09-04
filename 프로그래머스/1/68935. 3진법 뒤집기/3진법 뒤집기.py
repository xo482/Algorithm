def solution(n):
    ls = []
    while n > 0:
        ls.append(n%3)
        n //= 3
    ls.reverse()
    print(ls)
    
    i = 0
    ans = 0
    for x in ls:
        ans += x * (3 ** i)
        i += 1
    
    return ans
    