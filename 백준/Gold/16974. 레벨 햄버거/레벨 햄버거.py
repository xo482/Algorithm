N, x = map(int, input().split())

burger = [1]
patty = [1]

for _ in range(N):
    burger.append(burger[-1]*2+3)
    patty.append(patty[-1]*2+1)
    
def trac(n,x):
    if n == 0:
        return 1
    if x == 1:
        return 0
    
    if x == burger[n-1] + 2:
        return patty[n-1] + 1
    if x < burger[n-1] + 2:
        return trac(n-1, x-1)
    if x > burger[n-1] + 2:
        return patty[n-1] + 1 + trac(n-1, x - (burger[n-1] + 2))
    
    return -99999999

print(trac(N,x))